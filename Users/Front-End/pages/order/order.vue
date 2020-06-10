<template>
	<view class="container">
		<view class="navHead">
			<scroll-view scroll-x="true" style="white-space: nowrap; display: flex" scroll-with-animation
			:scroll-left="tabLeft">
			
				<view class="typeTile" :style='"width:" + itemsWidth + "px"' @click="typeTileClick(index)"
				:class="currentTab==index?'typeTileSel':'typeTile'" v-for="(item, index) in navTitile" :key="index">{{item}}</view>
			
				<view class="underineBox" :style='"transform:translateX("+isLeft+"px);width:"+ itemsWidth +"px"'>
					<view class="underline"></view>
				</view>
			</scroll-view>
		</view>
		<view class="body">
			<swiper :current="currentTab" @change="swiperTab" class="body-swiper">
				<!-- 待配送swiper -->
				<swiper-item>
					<scroll-view scroll-y="true" class="Orderscroll" scroll-with-animation="true">
					<view class="isEmpty" v-if="emptyJudge[0]">
						<image src="../../static/icon/index/main/order/暂无消息.png"></image>
						<text>暂无当前订单</text>
					</view>
					<view class="step-container" 
					@click="toOneOrder(item.order_ID)" 
					v-for="(item, index) in orderSimpInfo" 
					:key="index" v-if="item.order_State!='待评价' && item.order_State!='已完成'">
						<view class="oneOrderIcon">
							<image src="../../static/icon/index/main/order/餐盘.png"></image>
						</view>
						<text>您有一个订单在进行中</text>
						<view class="iconfont icon-jiantou toOneOrderIcon"></view>
						<view class="behindSpline"></view>
					</view>
					</scroll-view>
				</swiper-item>
				<!-- 待收货 -->
				<swiper-item>
					<scroll-view scroll-y="true" class="Orderscroll" scroll-with-animation="true">
						<view class="isEmpty" v-if="emptyJudge[1]">
							<image src="../../static/icon/index/main/order/暂无消息.png"></image>
							<text>暂无待收货订单</text>
						</view>
						<view class="get-container" v-for="(item, index) in orderSimpInfo" 
						:key="index" v-if="item.order_State=='待收货'">
							<view class="shopName">{{item.shop_Name}}</view>
							<view class="behindSpline"></view>
							<view class="getContent" @click="toOrderDetail(item.order_ID)">
								<view class="goodsName">{{item.trollyList[0].menu_Name}}等...</view>
								<view class="goodsTotal"><text style="color: #DD524D;margin-left: 6rpx;">￥{{item.order_Total}}</text></view>
							</view>
							<view class="btn-group">
								<button hover-class="btn-hover" 
								plain="true" hover-start-time="30"
								hover-stay-time="70" @click="crfOrder(item.order_ID)">确认收货</button>
							</view>
						</view>
					</scroll-view>
				</swiper-item>
				<!-- 待评价 -->
				<swiper-item>
					<scroll-view scroll-y="true" class="Orderscroll" scroll-with-animation="true">
						<view class="isEmpty" v-if="emptyJudge[2]">
							<image src="../../static/icon/index/main/order/暂无消息.png"></image>
							<text>暂无待评价订单</text></view>
						<view class="get-container" v-for="(item, index) in orderSimpInfo" 
						:key="index" v-if="item.order_State=='待评价'">
							<view class="shopName">{{item.shop_Name}}</view>
							<view class="behindSpline"></view>
							<view class="getContent" @click="toOrderDetail(item.order_ID)">
								<view class="goodsName">{{item.trollyList[0].menu_Name}}等...</view>
								<view class="goodsTotal"><text style="color: #DD524D;margin-left: 6rpx;">￥{{item.order_Total}}</text></view>
							</view>
							<view class="btn-group">
								<button hover-class="btn-hover" 
								plain="true" hover-start-time="30"
								hover-stay-time="70" @click="toAssess(item.order_ID)">去评价</button>
							</view>
						</view>
					</scroll-view>
				</swiper-item>
				<!-- 全部订单 -->
				<swiper-item>
					<scroll-view scroll-y="true" class="Orderscroll" scroll-with-animation="true">
						<view class="isEmpty" v-if="emptyJudge[3]">
							<image src="../../static/icon/index/main/order/暂无消息.png"></image>
							<text>暂无全部订单</text>
						</view>
						<view class="allOrder-container" v-for="(item, index) in orderSimpInfo" 
						:key="index" v-if="item.order_State=='已完成' || item.order_State=='待评价'">
							<view class="orderHead">
								<view class="leftSpImg">
									<image :src="item.shop_Image"></image>
								</view>
								<view class="rightOrderContent">
									<view class="rightOrderContent-name">{{item.shop_Name}}</view>
									<view class="rightOrderContent-time">{{item.order_Time}}</view>
								</view>
							</view>
							<view class="behindSpline"></view>
							<view class="cartList">
								<view class="oneCartGoods" v-for="(g, i) in item.trollyList" :key="i">
									<view class="leftGoodsImg">
										<image :src="g.menu_Photo"></image>
									</view>
									<view class="rightContent">
										<text style="font-size: 35rpx;">{{g.menu_Name}}</text>
										<text style="color: #999999;font-size: 32rpx;">×{{g.trolly_Num}}</text>
										<view class="goodsCost">￥{{g.trolly_Price}}</view>
									</view>
								</view>
							</view>
							<button hover-class="btn-hover"
							plain="true" hover-start-time="30"
							hover-stay-time="70" @click="toOrderDetail(item.order_ID)">订单详情</button>
						</view>
					</scroll-view>
				</swiper-item>
			</swiper>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				currentTab:0,
				itemsWidth:0,
				isLeft:0,
				navTitile:["当前订单","待收货","待评价","全部订单"],
				userID:'',
				orderSimpInfo:[],
				emptyJudge:[true,true,true,true]
			};
		},
		created() {
			let views = uni.createSelectorQuery().select(".navHead").boundingClientRect().exec(res=>{
					//console.log(res[0].width);
					this.itemsWidth = Math.floor(res[0].width / 4);
				})
		},
		onShow() {
			uni.showLoading({title: '加载中'});
			this.emptyJudge.splice(0, 4, true, true, true, true)
			this.initOrder();
		},
		onLoad() {
			this.userID = uni.getStorageSync('userID');
		},
		methods:{
			crfOrder(oID){
				var that = this;
				let index = this.orderSimpInfo.findIndex(item=> item.order_ID == oID);
				this.emptyJudge.splice(0, 4, true, true, true, true)
				uni.request({
					url:"http://47.112.243.221:8080/dFoods/user/order/confirm/"+oID,
					method:"GET",
					success: (res) => {
						if (res.data == "success"){
							uni.showToast({
								title:'收货成功',
								position:'center'
							});
							that.orderSimpInfo[index].order_State = "待评价";
							that.orderSimpInfo.forEach(item=>{
								if (item.order_State == "配送中"){
									that.emptyJudge.splice(0, 1, false);
								}
								if (item.order_State == "待收货"){
									that.emptyJudge.splice(0, 2, false, false);
								}
								if (item.order_State == "待评价"){
									that.emptyJudge.splice(2, 2, false, false);
								}
								if (item.order_State == "已完成"){
									that.emptyJudge.splice(3, 1, false);
								}
							})
						}else {
							uni.showToast({
								title:'收货失败',
								position:'center',
								icon:'none'
							});
						}
					},fail: () => {
						uni.showToast({
							title:'收货失败',
							position:'center',
							icon:'none'
						});
					}
				})
			},
			typeTileClick(index){
				//this.tabClick = index //设置导航点击了哪一个
				this.isLeft = index * this.itemsWidth //设置下划线位置
				this.currentTab = index;
			},
			// swiper 滑动 如果tab关联swiper需要写下面的方法 否则不写
			swiperTab: function(e) {
				//let index = e.detail.current 获取索引
				this.typeTileClick(e.detail.current);
			},
			toOrderDetail(oID){
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/order/orderDetail?orderID=' + oID
				});
				uni.hideLoading();
			},
			toAssess(oID){
				let index = this.orderSimpInfo.findIndex(item=> item.order_ID == oID);
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/order/assOrder?curtorder='+encodeURIComponent(JSON.stringify(this.orderSimpInfo[index]))
				});
				uni.hideLoading();
			},
			toOneOrder(oID){
				let url = '';
				for (let i = 0; i < this.orderSimpInfo.length; i++){
					if (this.orderSimpInfo[i].order_ID == oID){
						url = '/pages/order/currentOrder?orderID='+ oID;
						break;
					}
				}
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: url
				});
				uni.hideLoading();
			},
			onPullDownRefresh() {
				this.initOrder();
			},
			async initOrder(){
				var that = this;
				await uni.request({
					url:"http://47.112.243.221:8080/dFoods/user/order/all/"+that.userID,
					method:'GET',
					success: (res) => {
						console.log("initorder");
						console.log(res.data);
						that.orderSimpInfo = res.data;
						res.data.forEach(item=>{
							if (item.order_State == "配送中"){
								that.emptyJudge.splice(0, 1, false);
							}
							if (item.order_State == "待收货"){
								that.emptyJudge.splice(0, 2, false, false);
							}
							if (item.order_State == "待评价"){
								that.emptyJudge.splice(2, 2, false, false);
							}
							if (item.order_State == "已完成"){
								that.emptyJudge.splice(3, 1, false);
							}
						})
						uni.hideLoading();
						uni.stopPullDownRefresh();
					},
					fail: () => {
						uni.hideLoading();
						uni.stopPullDownRefresh();
						uni.showToast({
							title:'加载失败！',
							icon:'none',
							position:'center'
						})
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	page{
		background-color: #f2f2f2;
	}
	.container{
		overflow: hidden;
		position: relative;
	}
	.navHead{
		width: 100%;
		height: 100rpx;
		background-color: #FFFFFF;
		scroll-view{
			height: 100%;
			.underineBox{
				margin-top: 3rpx;
				height: 6rpx;
				display: flex;
				align-content: center;
				justify-content: center;
				transition: .5s;
				.underline {
					width: 130rpx;
					height: 6rpx;
					background-color: #f07373;
				}
			}
		}
	}
	.oneOrderIcon{
		height: 150rpx;
		margin-left: 10rpx;
		image{
			width: 150rpx;
			height: 150rpx;
		}
	}
	.toOneOrderIcon{
		font-size: 45rpx;
		margin-left: 35rpx;
	}
	.step-container{
		width: 700rpx;
		height: 200rpx;
		border-radius: 30rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: row;
		position: relative;
		align-items: center;
		.behindSpline{
			width: 100%;
			position: absolute;
			bottom: 10rpx;
		}
		text{
			font-size: 40rpx;
			font-weight: 550;
			height: 100rpx;
			line-height: 100rpx;
			margin-left: 20rpx;
		}
	}
	.typeTile{
		margin-top: 20rpx;
		display: inline-block;
		height: 55rpx;
		line-height: 55rpx;
		text-align: center;
		font-size: 30rpx;
		color: #7f7f7f;
		font-family: Microsoft Yahei;
		font-weight: 500;
	}
	.typeTileSel{
		font-size: 30rpx;
		margin-top: 20rpx;
		display: inline-block;
		height: 55rpx;
		line-height: 55rpx;
		text-align: center;
		font-size: 30rpx;
		color: #f07373;
		font-family: Microsoft Yahei;
		font-weight: 500;
	}
	.body{
		width: 100%;
		display: flex;
		flex-direction: column;
		justify-content: center;
		.body-swiper{
			width: 100%;
			height: 1000rpx;
		}
	}
	.cart-container{
		width: 700rpx;
		border-radius: 30rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		position: relative;
	}
	.cartList{
		display: flex;
		flex-direction: column;
		width: 650rpx;
		margin: 0rpx auto 20rpx auto;
		.oneCartGoods{
			display: flex;
			flex-direction: row;
			margin: 10rpx 0 10rpx 0;
			.leftGoodsImg{
				image{
					width: 100rpx;
					height: 100rpx;
				}
			}
			.rightContent{
				height: 100rpx;
				display: flex;
				flex-direction: column;
				position: relative;
				justify-content: space-between;
				width: 100%;
				margin-left: 20rpx;
				.goodsCost{
					position: absolute;
					right: 0rpx;
					bottom: 20rpx;
					color: #DD524D;
					font-weight: 550;
					font-size: 26rpx;
				}
			}
		}
	}
	.detail-container{
		width: 700rpx;
		border-radius: 30rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		position: relative;
		padding-top: 50rpx;
		padding-bottom: 10rpx;
		.oneDet{
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			align-items: center;
			font-size: 26rpx;
			margin: 0rpx 20rpx 15rpx 20rpx;
			.payType{
				font-weight: 520;
				color: #DD524D;
			}
		}
	}
	.shopName{
		font-size: 35rpx;
		font-weight: 550;
		font-family: Arial, Helvetica, sans-serif;
		margin: 20rpx 0rpx 10rpx 30rpx;
		letter-spacing: 3rpx;
	}
	.behindSpline{
		width: 650rpx;
		height: 2rpx;
		background-color: rgba(192, 192,192, 0.3);
		margin: 10rpx auto 20rpx auto;
	}
	.get-container{
		width: 700rpx;
		border-radius: 30rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		position: relative;
		.getContent{
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			align-items: center;
			font-size: 26rpx;
			margin: 0 20rpx 20rpx 20rpx;
			color: #999999;
		}
		.btn-group{
			button{
				display: inline-block;
				height: 60rpx;
				width: 160rpx;
				color: #f07373;
				float: right;
				margin: 10rpx 25rpx 25rpx 0rpx;
				border-radius: 10rpx;
				font-size: 25rpx;
				line-height: 58rpx;
				border: 2rpx solid #f07373;
			}
		}
	}
	.allOrder-container{
		width: 700rpx;
		border-radius: 30rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		.orderHead{
			margin: 20rpx;
			display: flex;
			flex-direction: row;
			position: relative;
			.leftSpImg{
				image{
					width: 100rpx;
					height: 100rpx;
				}
			}
			.rightOrderContent{
				width: 100%;
				height: 100rpx;
				display: flex;
				flex-direction: column;
				align-items: flex-start;
				justify-content: space-between;
				margin-left: 30rpx;
				.rightOrderContent-name{
					font-size: 35rpx;
					font-weight: 520;
				}
				.rightOrderContent-time{
					font-size: 25rpx;
					color: #AAAAAA;
				}
			}
		}
		button{
			display: inline-block;
			height: 60rpx;
			width: 160rpx;
			color: #f07373;
			margin: 0rpx 25rpx 25rpx 0rpx;
			border-radius: 10rpx;
			font-size: 25rpx;
			line-height: 58rpx;
			border: 2rpx solid #f07373;
			align-self: flex-end;
		}
	}
	.Orderscroll{
		width: 100%;
		height: 100%;
	}
	.isEmpty{
		color: #AAAAAA;
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		height: 300rpx;
		image{
			width: 200rpx;
			height: 200rpx;
		}
	}
</style>
