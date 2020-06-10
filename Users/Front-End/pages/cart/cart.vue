<template>
	<view class="container">
		<view class="body">
			<!-- 购物车顶部商家信息 -->
			<view class="top">
				<view class="shopImg">
					<image :src="shopInfo.shop_Image" mode="scaleToFill"></image>
				</view>
				<view class="top-name">{{shopInfo.shop_Name}}</view>
				<view class="top-content">
					<view>营业时间： {{shopInfo.shop_RunTime}}
						<text style="margin-left: 60rpx;">{{shopInfo.shop_Distance}}</text>
						<text style="margin-left: 60rpx;">评分：<text style="color:#e03a24">{{shopInfo.shop_Qrade}}</text></text>
					</view>
					<view>{{shopInfo.shop_Address}}
					</view>
				</view>
			</view>
			<!-- 信息滚动栏以及商品信息 -->
			<view class="mid-body">
				<!-- 商品分类swiper -->
				<view class="goodsAndComm">
					<scroll-view scroll-x="true" style="white-space: nowrap; display: flex" scroll-with-animation 
					:scroll-left="tabLeft">
						<view :style='"width:" + itemsWidth + "px"' @click="typeTileClick(0)" 
						:class="currentTab==0?'typeTileSel':'typeTile'">商品</view>
						<view class="typeTile" :style='"width:" + itemsWidth + "px"' @click="typeTileClick(1)"
						:class="currentTab==1?'typeTileSel':'typeTile'">评论</view>
			
						<view class="underineBox" :style='"transform:translateX("+isLeft+"px);width:"+ itemsWidth +"px"'>
							<view class="underline"></view>
						</view>
					</scroll-view>
				</view>
				<swiper :current="currentTab" @change="swiperTab" class="swiperitem-cart-body">
					<!-- 商品swiper -->
					<swiper-item >
						<view class="cart-body">
							<!-- 左侧菜单分类 -->
							<scroll-view class="left-menus" scroll-with-animation="true" scroll-y="true">
								<view class="menu" v-for="(item, index) in goods" :key="index"
								:id="'m' + index"
								:class="currentType==index?'selected':''"
								:data-index="index"
								@tap="setId">
									<text class="menutitle">{{item.type_Name}}</text>
									<view class="dot" v-show="goodTypeNum(item.type_ID)">{{goodTypeNum(item.type_ID)}}</view>
								</view>
							</scroll-view>
							<!-- 右侧商品分类 -->
							<scroll-view class="right-goods" scroll-with-animation="true" scroll-y="true" 
							:scroll-into-view="viewId" show-scrollbar="false" @scroll="srollSetMenu">	
										
								<view class="goods" v-for="(item, index) in goods" :key="index" :id="'g' + index">
									<view class="goods-title">{{item.type_Name}}</view>
									<view class="one-goods" v-for="(g , f) in item.goodsList" :key="f">
										<view class="left-img" @click="lookUpGoodsDeateil(g, item.type_ID)">
											<image :src="g.menu_Photo"></image>
										</view>
										<view class="right-info">
											<view class="right-info-title">{{g.menu_Name}}</view>
											<view class="right-info-descibe">{{g.menu_Introduce}}</view>
											<view class="one-goods-bottom">
												<text class="price">￥{{g.menu_Price}}</text>
												<view class="addAdec">
													<image src="../../static/icon/index/main/cart/offline_fill.png" 
													class="dec" v-show="goodCartNum(g.menu_ID)" @click="decCart(g)"></image>
													<view class="Num" v-show="goodCartNum(g.menu_ID)">{{goodCartNum(g.menu_ID)}}</view>
													<image src="../../static/icon/index/main/cart/addition_fill.png" 
													class="add" @click="addCart(item.type_ID, g, 1)"></image>
												</view>
											</view>
										</view>
									</view>
								</view>
								<view class="fill-last" :style="{ 'height':fillHeight + 'px' }"></view>
							</scroll-view>
						</view>
					</swiper-item>
					<!-- 评论swiper -->
					<swiper-item>
						<view class="comt-body">
							<scroll-view scroll-y="true" scroll-with-animation="true" class="scrollBody">
								<view class="oneCom" v-for="(item, index) in shopAsses" :key="index">
									<view class="oneCom-head">
										<view class="oneCom-left">
											<image :src="item.user_HeadImg"></image>
										</view>
										<view class="oneCom-right">
											<view class="oneCom-right-name">{{item.user_Name}}</view>
											<view class="oneCom-right-timewlevel">
												<view class="level">
													<uni-rate :value="item.ass_Rate" size="12" disable="true"></uni-rate>
												</view>
												<view class="time">{{item.ass_Time}}</view>
											</view>
										</view>
									</view>
									<view class="oneCom-content">
										{{item.ass_Content}}
									</view>
									<view class="one-line"></view>
								</view>					
							</scroll-view>
						</view>
					</swiper-item>
				</swiper>

			</view>
			
			<!-- 底部购物车栏 -->
			<view class="bottom-cart">
				<view class="carticon">
					<image src="../../static/icon/index/main/cart/购物车.png" @click="openPopup"></image>
				</view>
				<view class="cartTitle">￥{{totalPrice}}
					<text>另需配送费￥{{shopInfo.shop_RunCost}}</text>
				</view>
				<view class="toOrder" @click="goOrder" v-if="!disabledPay">
					去结算
				</view>
				<view class="noToOrder" v-if="disabledPay">
					差￥{{spread}}起送
				</view>
			</view>
			
			<!-- 购物车弹出层 -->
			<uni-popup ref="popup" type="bottom" style="z-index: 9900;">
				<view class="popoup">
					<view class="popoupTop">
						<image src="../../static/icon/index/main/cart/delcart.png" @click="clearCart"></image>
					</view>
					<view class="line"></view>
					<view class="popupContent">
						<scroll-view class="oneContent-scroll" scroll-y="true" scroll-with-animation="true">
							<view class="oneContent" v-for="(item, index) in cart" :key="index">
								<view class="oneContentTitle">{{item.name}}</view>
								<view class="one-goods-bottom">
									<text class="price">￥{{item.price}}</text>
									<view class="addAdec">
										<image src="../../static/icon/index/main/cart/offline_fill.png" 
										class="dec" v-show="goodCartNum(item.id)" @click="popDecCart(item.id)"></image>
										<view class="Num" v-show="goodCartNum(item.id)">{{goodCartNum(item.id)}}</view>
										<image src="../../static/icon/index/main/cart/addition_fill.png" 
										class="add" @click="popAddCart(item.id, 1)"></image>
									</view>
								</view>
							</view>
						</scroll-view>
					</view>
				</view>
			</uni-popup>
		</view>
		
		<uni-popup ref="popupMess" type="center">
			 <view class="popMess">
			 	购物车为空！
			 </view>
		</uni-popup>
		
		<uni-popup ref="popupGoodsDetail" type="center">
			 <view class="popupGoodsDetail">
			 	<view class="oneGoodsImg">
					<image :src="oneGoods.menu_Photo"></image>
				</view>
				<view class="oneGoodsName">
					{{oneGoods.menu_Name}}
				</view>
				<view class="oneGoodsIntroduce">
					{{oneGoods.menu_Introduce}}
				</view>
				<view class="one-goods-bottom popOneGoodsBtm">
					<text class="price">￥{{oneGoods.menu_Price}}</text>
					<view class="addAdec">
						<image src="../../static/icon/index/main/cart/offline_fill_white.png" 
						class="dec" v-show="goodCartNum(oneGoods.menu_ID)" @click="decCart(oneGoods)"></image>
						<view class="Num" v-show="goodCartNum(oneGoods.menu_ID)">{{goodCartNum(oneGoods.menu_ID)}}</view>
						<image src="../../static/icon/index/main/cart/addition_fill_white.png" 
						class="add" @click="addCart(oneGoodsTypeId, oneGoods, 1)"></image>
					</view>
				</view>
			 </view>
		</uni-popup>
	</view>
	
</template>

<script>
	import uniNoticeBar from '@/components/uni-notice-bar/uni-notice-bar.vue'
	import uniPopup from '@/components/uni-popup/uni-popup.vue'
	import uniPopupMessage from '@/components/uni-popup/uni-popup-message.vue'
	import uniPopupDialog from '@/components/uni-popup/uni-popup-dialog.vue'
	import uniRate from '@/components/uni-rate/uni-rate.vue'
	export default {
		data(){
			return{
				viewId:'',
				goodsHeight:[],
				cart:[],
				currentType:0,
				total:0,
				isShow:false,
				isCartPopUp:false,
				currentTab: 0, //sweiper所在页
				isLeft:0, //导航栏下划线位置
				tabLeft:0,
				tabTitle:['商品','评论'],
				itemsWidth:0,
				sid:0,
				shopInfo:[],
				goods:[],
				oneGoods:{},
				oneGoodsTypeId:0,
				scrollHeight:370,
				scrollTopSize:0,
				fillHeight:0,	// 填充高度，用于最后一项低于滚动区域时使用
				topArr:[],
				shopOrderInfo:[],
				userID:'',
				shopAsses:[]
			}
		},
		computed:{
			spread() { //差多少元起送
				return (this.shopInfo.shop_RunStartCost - this.totalPrice) < 0 ? 0 : (this.shopInfo.shop_RunStartCost - this.totalPrice);
			},
			disabledPay() { //是否达到起送价
				return (this.totalPrice < this.shopInfo.shop_RunStartCost) ? true : false
			},
			totalPrice(){
				return this.cart.reduce((acc, cur) => acc + cur.num * cur.price, 0);
			},
			cartGoodTypeNum(){
				return ()=> this.cart.reduce((acc, cur) => acc + cur.num , 0);
			},
			goodTypeNum() {
				return (tid) => { return this.cart.reduce((acc, cur)=> {
						if (cur.typeId == tid){
							return acc += cur.num
						}
						return acc
					}, 0)
				}
			},
			goodCartNum() {
				return (shopId) => this.cart.reduce((acc, cur) => {
						//console.log(acc);
						if(cur.id === shopId) {
							return acc += cur.num
						}
						return acc;
					}, 0)
			}
		},
		async onLoad(obj) {
			this.sid = obj.sid;
			uni.showLoading({title:'加载中'});
			await this.initShop();
			await this.initMenus();
			await this.initAss();
			uni.hideLoading();
		},
		mounted() {
			this.$nextTick(()=>{
				setTimeout(()=>{
					this.initScrollView().then(()=>{
						/* 获取列表数据，你的代码从此处开始 */
						this.$nextTick(()=>{
							this.getAllGoodsHeight();
							this.getElementTop();
						})
					})
				},200)
			})
		},
		created() {
			let views = uni.createSelectorQuery().select(".goodsAndComm").boundingClientRect().exec(res=>{
					//console.log(res[0].width);
					this.itemsWidth = Math.floor(res[0].width / 2);
			})
		},
		components: {
			uniNoticeBar,
			uniPopup,
			uniPopupMessage,
			uniPopupDialog,
			uniRate
		},
		methods:{
			async initAss(){
				var _this = this;
				 await uni.request({
				 	url:"http://47.112.243.221:8080/dFoods/sp/ass/" + _this.sid,
					method:'GET',
					success: (res) => {
						_this.shopAsses = res.data;
					}
				 })
			},
			async initMenus(){
				var _this = this;
				await uni.request({
					url:"http://47.112.243.221:8080/dFoods/sp/menu/" + _this.sid,
					method:"GET",
					success(res) {
						_this.goods = res.data;
					}
				})
			},
			async initShop(){
				var _this = this;
				await uni.request({
					url:"http://47.112.243.221:8080/dFoods/sp/" + _this.sid,
					method:"GET",
					success(res) {
						_this.shopInfo = res.data;
						_this.shopOrderInfo.push({
							shopID:res.data.shop_ID,
							shopName:res.data.shop_Name,
							RunCost:res.data.shop_RunCost
						});
					}
				})
			},
			lookUpGoodsDeateil(g, typeID){
				this.oneGoods = g;
				this.oneGoodsTypeId = typeID;
				this.$refs.popupGoodsDetail.open();
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
			setId(e){
				let index=e.currentTarget.dataset.index;
				this.viewId = `g${index}`;
				this.currentType = index;
			},
			srollSetMenu(e){
				let goodsScrollTop = e.detail.scrollTop;
				//console.log("goodsScrollTop" + goodsScrollTop);
				for(let i = 0; i < this.goodsHeight.length; i++){
					if(this.goodsHeight[i] < goodsScrollTop && this.goodsHeight[i + 1] > goodsScrollTop){
						this.currentType = i;
						break;
						//console.log(this.currentType);
					}
				}
			},
			/* 初始化滚动区域 */
			initScrollView(){
				return new Promise((resolve, reject)=>{
					let view = uni.createSelectorQuery().select('.cart-body');
					view.boundingClientRect(res => {
						console.log(res);
						this.scrollTopSize = res.top;
						this.scrollHeight = res.height;
						this.$nextTick(()=>{
							resolve();
						})
					}).exec();
				});
			},
			getAllGoodsHeight(){
				let h = 0;
				this.goodsHeight.push(0);
				let views = uni.createSelectorQuery().selectAll(".goods").boundingClientRect().exec(data=>{
					console.log(data);
					data[0].forEach(item=>{
						h += (item.height - 10);
						//console.log(h);
						this.goodsHeight.push(h);
					})
				})
			},
			getElementTop(){
				new Promise((resolve,reject)=>{
					let view = uni.createSelectorQuery().selectAll('.goods');
					view.boundingClientRect(data => {
						resolve(data);
					}).exec();
				}).then((res)=>{
					//console.log(res[res.length-1]);
					let topArr = res.map(item=>{
						return item.top - this.scrollTopSize;
					});
					this.topArr = topArr;
					/* 获取最后一项的高度，设置填充高度。判断和填充时做了 +-20 的操作，是为了滚动时更好的定位 */
					let last = res[res.length-1].height;			
					if(last < this.scrollHeight){
						this.fillHeight = this.scrollHeight - last;
					}
				});
			},
			goOrder(){
				this.userID = uni.getStorageSync('userID');
				if (this.cart.length <= 0){
					this.$refs.popupMess.open();
				}
				else{
					if (this.userID == '' || this.userID == null){				
						uni.showModal({
							title:"提示",
							content:"请先登录！",
							success:(res)=>{
								if (res.confirm){
									uni.showLoading({title: '加载中'});
									uni.navigateTo({
										url:"../info/login"
									})
									uni.hideLoading();
								}
							}
						})
					}else {
						uni.showLoading({title: '加载中'});
						uni.setStorageSync('cart', JSON.parse(JSON.stringify(this.cart)));
						uni.navigateTo({
							url: '/pages/order/payOrder?shopOrderInfo='+encodeURIComponent(JSON.stringify(this.shopOrderInfo))
						})
						uni.hideLoading();
					}
				}
			},
			addCart(typeId, goods, num){
				// console.log("addCart item:" + item.shop);
				// console.log("addCart goods:" + goods);
				this.isShow = true;
				let index = this.cart.findIndex(it=>{
					return it.id == goods.menu_ID;
				});
				//console.log("addCart:" + index);
				if (index > -1){
					this.cart[index].num += num;
				}else{
					this.cart.push({
						id:goods.menu_ID,
						name:goods.menu_Name,
						typeId:typeId,
						num:num,
						price:goods.menu_Price,
						img:goods.menu_Photo
					})
				}
			},
			popAddCart(id, num){
				let index = this.cart.findIndex(it=> it.id == id);
				if (index > -1){
					this.cart[index].num += num;
				}
			},
			decCart(goods){
				let index = this.cart.findIndex(item => item.id == goods.menu_ID);
				//console.log("decCart:" + index);
				this.cart[index].num -= 1
				if(this.cart[index].num <= 0) {
					this.cart.splice(index, 1);
					this.isShow = false;
				}
			},
			popDecCart(id){
				let index = this.cart.findIndex(item => item.id == id);
				this.cart[index].num -= 1;
				if(this.cart[index].num <= 0) {
					this.cart.splice(index, 1);
					this.isShow = false;
				}
			},
			openPopup(){
				this.isCartPopUp = !this.isCartPopUp;
				if(this.isCartPopUp && this.cart.length > 0){
					this.$refs.popup.open();
				}else{
					this.$refs.popup.close();
				}
			},
			clearCart(){
				this.cart = [];
			}
		}
	}
</script>

<style lang="scss">
	page{
		background-color: #FFFFFF;
	}
	.container{
		overflow: hidden;
		position: relative;
	}
	.body{
		height: 100%;
		width: 100%;
	}
	.top{
		height: 210rpx;
		box-shadow: 0 0rpx 20rpx 10rpx rgba(51, 51, 51, 0.1);
		border-radius: 30rpx;
		position: relative;
		margin-top: 55rpx;
		margin-left: 20rpx;
		margin-right: 20rpx;
		background-color: #FFFFFF;
		.shopImg{
			position: absolute;
			top: -50rpx;
			left: 50rpx;
			image{
				width: 150rpx;
				height: 150rpx;
				border-radius: 50%;
				border: 2rpx solid #C0C0C0;
			}
		}
		.top-name{
			display: inline-block;
			font-size: 40rpx;
			font-weight: bold;
			margin-left: 220rpx;
			margin-top: 25rpx;
		}
		.top-content{
			color: #999999;
			font-size: 25rpx;
			margin-left: 50rpx;
			margin-top: 40rpx;
			view{
				margin-bottom: 10rpx;
			}
		}
	}
	.mid-body{
		margin-top: 20rpx;
		padding-left: 20rpx;
		padding-right: 20rpx;
		height: 100%;
		.goodsAndComm{
			width: 300rpx;
			position: relative;
			scroll-view{
				height: 88rpx;
				.underineBox{
					margin-top: 3rpx;
					height: 6rpx;
					display: flex;
					align-content: center;
					justify-content: center;
					transition: .5s;
					.underline {
						width: 100rpx;
						height: 6rpx;
						background-color: #f07373;
					}
				}
			}
			.typeTile{
				display: inline-block;
				height: 55rpx;
				line-height: 55rpx;
				text-align: center;
				font-size: 32rpx;
				color: #636e72;
				font-family: Microsoft Yahei;
				font-weight: 500;
			}
			.typeTileSel{
				display: inline-block;
				height: 55rpx;
				line-height: 55rpx;
				text-align: center;
				font-size: 32rpx;
				color: #f07373;
				font-family: Microsoft Yahei;
				font-weight: 500;
			}
		}
	}
	.swiperitem-cart-body{
		height: 740rpx;
		width: 100%;
	}
	.cart-body{
		height: 740rpx;
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: flex-start;
		overflow:hidden;
		.left-menus{
			position: relative;
			width: 200rpx;
			height: 100%;
			background-color: #F1F1F1;
			display: flex;
			flex-direction: column;
			align-items: center;
			.menu{
				display: flex;
				flex-direction: row;
				justify-content: center;
				align-items: center;
				height: 80rpx;
				position: relative;
				.menutitle{
					color: #999999;
					font-size: 28rpx;
				}
			}
		}
		.right-goods{
			width: 100%;
			height: 100%;
			padding: 10rpx;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			.goods{
				display: flex;
				flex-direction: column;
				padding-left: 5rpx;
				padding-right: 5rpx;
				margin-bottom: 20rpx;
				.goods-title{
					margin-left: 18rpx;
					font-weight: 550;
					margin-bottom: 20rpx;
					color: #f07373;
					letter-spacing: 6rpx;
				}
				.one-goods{
					height: 210rpx;
					border-radius: 30rpx;
					box-shadow: 0 0 10rpx 2rpx rgba(51, 51, 51, 0.2);
					background-color: #FFFFFF;
					margin-bottom: 20rpx;
					display: flex;
					flex-direction: row;
					position: relative;
					align-items: center;
					.left-img{
						height: 150rpx;
						image{
							width: 160rpx;
							height: 160rpx;
							border-radius: 8rpx;
						}
						margin: 20rpx;
					}
					.right-info{
						height: 160rpx;
						flex: 1;
						display: flex;
						flex-direction: column;
						margin-left: 6rpx;
						position: relative;
						justify-content: space-between;
						align-items: flex-start;
						padding-right: 15rpx;
						.right-info-title{
							font-size: 30rpx;
							font-weight: bold;
						}
						.right-info-descibe{
							width: 250rpx;
							overflow: hidden;
							text-overflow: ellipsis;
							white-space: nowrap;
							font-size: 25rpx;
							color: #919293;
							height: 40rpx;
							line-height: 40rpx;
							margin-bottom: 10rpx;
						}
					}
				}
			}
		}
	}
	.popOneGoodsBtm{
		border-radius: 0 0 30rpx 30rpx;
		height: 60rpx;
		background-color: #f07373;
		text{
			color: #FFFFFF;
			margin-left: 25rpx;
		}
		.addAdec{
			margin-right: 25rpx;
			color: #FFFFFF;
		}
	}
	.one-goods-bottom{
		display: flex;
		width: 100%;
		position: relative;
		align-items: center;
		justify-content: space-between;
		image{
			width: 50rpx;
			height: 50rpx;
		}
		.addAdec{
			display: flex;
			justify-content: space-between;
			align-items: center;
			position: relative;
			.dec{
				margin-right: 10rpx;
			}
			.Num{
				margin-right: 10rpx;
			}
		}
		.price{
			font-size: 28rpx;
			font-weight: 600;
		}
	}
	.bottom-cart{
		z-index: 9990;
		width: 90%;
		height: 100rpx;
		background-color: #FFFFFF;
		position: relative;
		bottom: 25rpx;
		display: flex;
		flex-direction: row;
		border-radius: 30rpx;
		margin: 0 auto 0 auto;
		box-shadow: 0 0 10rpx 6rpx rgba(51, 51, 51, 0.2);
		.carticon{
			position: relative;
			image{
				width: 120rpx;
				height: 120rpx;
				position: absolute;
				top: -50rpx;
				left: 30rpx;
			}
		}
		.cartTitle{
			height: 100%;
			display: flex;
			height: 80rpx;
			margin: auto 0 auto 180rpx;
			flex-direction: column;
			align-items: flex-start;
			font-weight: 520;
			font-size: 35rpx;
			color: #f07373;
			text{
				font-size: 25rpx;
				color: #999999;
			}
		}
		.toOrder{
			position: absolute;
			font-weight: 520;
			font-size: 35rpx;
			color: #FFFFFF;
			background-color: #f07373;
			width: 180rpx;
			right: 0rpx;
			height: 100%;
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: center;
			letter-spacing: 6rpx;
			border-radius: 0 30rpx 30rpx 0;
		}
		.noToOrder{
			position: absolute;
			font-weight: 520;
			width: 180rpx;
			font-size: 30rpx;
			color: #FFFFFF;
			background-color: rgba(240, 115, 155, 0.5);
			right: 0rpx;
			height: 100%;
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: center;
			border-radius: 0 30rpx 30rpx 0;
		}
	}
	.dot{
		position: absolute;
		width: 23rpx;
		height: 23rpx;
		line-height: 20rpx;
		font-size: 18rpx;
		background-color: #c0392b;
		color: #ffffff;
		top: 15rpx;
		right: 10rpx;
		border-radius: 100%;
		text-align: center;
	}
	.selected{
		background-color: #FFFFFF;
	}
	.line{
		width: 700rpx;
		margin-top: 20rpx;
		height: 3rpx;
		background-color: #bdc3c7;
		margin-top: 12rpx;
	}
	.popoup{
		height: 500rpx;
		width: 100%;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		border-radius: 30rpx 30rpx 0 0;
		.popoupTop{
			height: 100rpx;
			width: 100%;
			position: relative;
			image{
				height: 50rpx;
				width: 50rpx;
				position: absolute;
				right: 20rpx;
				top: 20rpx;
			}
		}
		.popupContent{
			width: 100%;
			height: 100%;
			display: flex;
			flex-direction: column;
			position: relative;
			.oneContent-scroll{
				height: 260rpx;
				.oneContent{
					height: 80rpx;
					display: flex;
					flex-direction: row;
					justify-content: space-between;
					align-items: center;
					padding-left: 35rpx;
					padding-right: 35rpx;
					.oneContentTitle{
						width: 300rpx;
						overflow: hidden;
						text-overflow: ellipsis;
						white-space: nowrap;
						height: 40rpx;
						line-height: 40rpx;
					}
				}
			}
		}
	}
	.comt-body{
		height: 730rpx;
	}
	.popMess{
		display: flex;
		align-items: center;
		justify-content: center;
		border-radius: 30rpx;
		width: 300rpx;
		height: 150rpx;
		background-color: #FFFFFF;
	}
	.popupGoodsDetail{
		width: 500rpx;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		border-radius: 30rpx;
		.oneGoodsImg{
			width: 200rpx;
			margin: 20rpx auto 20rpx auto;
			image{
				width: 200rpx;
				height: 200rpx;
			}
		}
		.oneGoodsName{
			font-weight: bold;
			margin: 0 0 25rpx 25rpx;
			font-size: 30rpx;
		}
		.oneGoodsIntroduce{
			color: #919293;
			margin: 0 25rpx 25rpx 25rpx;
			font-size: 25rpx;
		}
	}
	.scrollBody{
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		.oneCom{
			width: 90%;
			display: flex;
			flex-direction: column;
			justify-content: flex-start;
			align-items: center;
			position: relative;
			margin: 0rpx auto 20rpx auto;
			.one-line{
				margin-top: 20rpx;
				width: 100%;
				height: 2rpx;
				background-color: #bdc3c7;
			}
			.oneCom-content{
				margin-top: 10rpx;
				width: 100%;
				color: #7f8c8d;
				font-size: 30rpx;
				line-height: 50rpx;
			}
			.oneCom-head{
				width: 100%;
				display: flex;
				flex-direction: row;
				justify-content: flex-start;
				align-items: flex-start;
				.oneCom-left{
					width: 120rpx;
					image{
						width: 100rpx;
						height: 100rpx;
						border-radius: 100%;
					}
				}
				.oneCom-right{
					margin-left: 50rpx;
					width: 100%;
					height: 100%;
					display: flex;
					flex-direction: column;
					justify-content: flex-start;
					align-items: flex-start;
					position: relative;
					.oneCom-right-name{
						width: 100%;
						font-size: 35rpx;
						font-weight: 520;
						font-family: Arial, Helvetica, sans-serif;
					}
					.oneCom-right-timewlevel{
						margin-top: 20rpx;
						display: flex;
						flex-direction: row;
						justify-content: space-around;
						align-items: center;
						.level{
							width: 150rpx;
							height: 30rpx;
							display: flex;
							flex-direction: row;
							justify-content: flex-start;
							align-items: center;
							margin-right: 20rpx;
						}
						.time{
							font-size: 30rpx;
							color: #636e72;
							line-height: 30rpx;
							height: 30rpx;
						}
					}
				}
			}
		}
	}
	.fill-last{
		height: 0;
		width: 100%;
		background: none;
	}
</style>
