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
					<view class="step-container">
						<view class="status" style="color: #f07373;">
							<view class="iconfont icon-order statusIcon"></view>
							<view class="statusCont">已下单</view>
						</view>
						<view class="status">
							<view class="iconfont icon-runorder statusIcon"></view>
							<view class="statusCont">配送中</view>
						</view>
						<view class="status">
							<view class="iconfont icon-overorder statusIcon"></view>
							<view class="statusCont">已签收</view>
						</view>
						<view class="line-f line"></view>
						<view class="line-s line"></view>
					</view>
					<view class="cart-container">
						<view class="shopName">星巴克</view>
						<view class="behindSpline"></view>
						<view class="cartList">
							<view class="oneGoods">
								<view class="headName">杨枝甘露</view>
								<view class="midNum">×1</view>
								<view class="tailPrice">￥50.00</view>
							</view>
							<view class="oneGoods">
								<view class="headName">甘露</view>
								<view class="midNum">×1</view>
								<view class="tailPrice">￥50.00</view>
							</view>
							<view class="oneGoods">
								<view class="headName">柠檬汁</view>
								<view class="midNum">×6</view>
								<view class="tailPrice">￥60.00</view>
							</view>
						</view>
					</view>
					<view class="detail-container">
						<view class="behindSpline"></view>
						<view class="oneDet">
							<view class="payTypeTitle">支付方式</view>
							<view class="payType">微信支付</view>
						</view>
						<view class="oneDet">
							<view class="payTypeTitle">总金额</view>
							<view class="payType">￥150.00</view>
						</view>
					</view>
				</swiper-item>
				<!-- 待收货 -->
				<swiper-item>
					<view class="get-container">
						<view class="shopName">星巴克</view>
						<view class="behindSpline"></view>
						<view class="getContent" @click="toOrderDetail">
							<view class="goodsName">杨枝甘露等...</view>
							<view class="goodsTotal"><text style="color: #DD524D;margin-left: 6rpx;">￥150.00</text></view>
						</view>
						<view class="btn-group">
							<button hover-class="btn-hover" 
							plain="true" hover-start-time="30"
							hover-stay-time="70">确认收货</button>
						</view>
					</view>
				</swiper-item>
				<!-- 待评价 -->
				<swiper-item>
					<view class="get-container">
						<view class="shopName">星巴克</view>
						<view class="behindSpline"></view>
						<view class="getContent" @click="toOrderDetail">
							<view class="goodsName">杨枝甘露等...</view>
							<view class="goodsTotal"><text style="color: #DD524D;margin-left: 6rpx;">￥150.00</text></view>
						</view>
						<view class="btn-group">
							<button hover-class="btn-hover" 
							plain="true" hover-start-time="30"
							hover-stay-time="70" @click="toAssess">去评价</button>
						</view>
					</view>
				</swiper-item>
				<!-- 全部订单 -->
				<swiper-item>
					<view class="allOrder-container">
						<view class="orderHead">
							<view class="leftSpImg">
								<image src="../../static/icon/index/main/cart/kfc.jpg"></image>
							</view>
							<view class="rightOrderContent">
								<view class="rightOrderContent-name">肯德基</view>
								<view class="rightOrderContent-time">2020-5-20 15:30</view>
							</view>
						</view>
						<view class="behindSpline"></view>
						<view class="cartList">
							<view class="oneGoods">
								<view class="headName">杨枝甘露</view>
								<view class="midNum">×1</view>
								<view class="tailPrice">￥50.00</view>
							</view>
							<view class="oneGoods">
								<view class="headName">甘露</view>
								<view class="midNum">×1</view>
								<view class="tailPrice">￥50.00</view>
							</view>
							<view class="oneGoods">
								<view class="headName">柠檬汁</view>
								<view class="midNum">×6</view>
								<view class="tailPrice">￥60.00</view>
							</view>
						</view>
						<button hover-class="btn-hover"
						plain="true" hover-start-time="30"
						hover-stay-time="70" @click="toOrderDetail">订单详情</button>
					</view>
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
				navTitile:["配送中","待收货","待评价","全部订单"]
			};
		},
		created() {
			let views = uni.createSelectorQuery().select(".navHead").boundingClientRect().exec(res=>{
					//console.log(res[0].width);
					this.itemsWidth = Math.floor(res[0].width / 4);
				})
		},
		methods:{
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
			toOrderDetail(){
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/order/orderDetail'
				});
				uni.hideLoading();
			},
			toAssess(){
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/order/assOrder'
				});
				uni.hideLoading();
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
	.step-container{
		width: 700rpx;
		height: 250rpx;
		border-radius: 30rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: row;
		position: relative;
		.status{
			width: 120rpx;
			height: 120rpx;
			margin: 50rpx auto 0rpx auto;
			display: flex;
			flex-direction: column;
			align-items: center;
			.statusIcon{
				font-size: 80rpx;
			}
			.statusCont{
				margin-top: 20rpx;
				font-size: 27rpx;
			}
		}
		.line{
			position: absolute;
			width: 125rpx;
			height: 3rpx;
			background-color: #2c3e50;
			bottom: 72rpx;
		}
		.line-f{
			left: 170rpx;
		}
		.line-s{
			right: 170rpx;
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
		.oneGoods{
			font-size: 26rpx;
			display: flex;
			flex-direction: row;
			position: relative;
			margin-bottom: 10rpx;
			color: #AAAAAA;
			.headName{
				width: 200rpx;
			}
			.tailPrice{
				font-weight: 520;
				position: absolute;
				right: 0rpx;
				color: #DD524D;;
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
</style>
