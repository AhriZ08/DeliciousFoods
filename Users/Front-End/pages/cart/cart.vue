<template>
	<view class="container">
		<view class="top">
			<view class="shopImg">
				<image src="../../static/icon/index/main/cart/kfc.jpg" mode="scaleToFill"></image>
			</view>
			<view class="top-name">KFC(成都信息工程大学)</view>
			<view class="top-content">
				<view>距离您1km</view>
				<view>成都双流区航空港街道123号</view>
			</view>
		</view>
		<view class="mid-body">
			<uni-notice-bar scrollable="true" single="true" text="最新推出肯德基十翅一桶，蜜汁鸡翅和炸鸡激情碰撞，更有惊喜抽奖活动，立即下单吧！" 
			showIcon="true" speed="60"></uni-notice-bar>
			<view class="cart-body">
				<scroll-view class="left-menus" scroll-with-animation="true" scroll-y="true">
					<view class="menu" v-for="(item, index) in goods" :key="index"
					:id="'m' + index"
					:class="currentType==index?'selected':''"
					@click="setId(index)">
						<text class="menutitle">{{item.type}}</text>
						<view class="dot" v-show="goodTypeNum(item.typeId)">{{goodTypeNum(item.typeId)}}</view>
					</view>
				</scroll-view>
				<scroll-view class="right-goods" scroll-with-animation="true" scroll-y="true" 
				:scroll-into-view="viewId" show-scrollbar="false" @scroll="srollSetMenu">				
					<view class="goods" v-for="(item, index) in goods" :key="index" :id="'g' + index">
						<view class="goods-title">{{item.type}}</view>
						<view class="one-goods" v-for="(g , f) in item.shop" :key="f">
							<view class="left-img">
								<image src="../../static/icon/index/main/cart/logo.png"></image>
							</view>
							<view class="right-info">
								<view class="right-info-title">{{g.name}}</view>
								<view class="right-info-descibe">{{g.descibe}}</view>
								<view class="one-goods-bottom">
									<text class="price">￥{{g.price}}</text>
									<view class="addAdec">
										<image src="../../static/icon/index/main/cart/offline_fill.png" 
										class="dec" v-show="goodCartNum(g.shopId)" @click="decCart(item, g)"></image>
										<view class="Num" v-show="goodCartNum(g.shopId)">{{goodCartNum(g.shopId)}}</view>
										<image src="../../static/icon/index/main/cart/addition_fill.png" 
										class="add" @click="addCart(item, g, 1)"></image>
									</view>
								</view>
							</view>
						</view>
					</view>
				</scroll-view>
			</view>
		</view>
		<view class="bottom-cart">
			<view class="carticon">
				<image src="../../static/icon/index/main/cart/cart.png" @click="openPopup"></image>
			</view>
			<view class="cartTitle">合计:￥{{totalPrice}}</view>
			<view class="toOrder" @click="goOrder">支付</view>
		</view>
		<uni-popup ref="popup" type="bottom" style="z-index: 9900;">
			<view class="popoup">
				<view class="popoupTop">
					<image src="../../static/icon/index/main/cart/delcart.png" @click="clearCart"></image>
				</view>
				<view class="popupContent">
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
	export default {
		data(){
			return{
				viewId:"g0",
				goodsHeight:[],
				cart:[],
				currentType:0,
				total:0,
				goodsNum:1,
				isShow:false,
				isCartPopUp:false,
				goods:[{
						type:"人气热卖",
						typeId:0,
						shop:[{
							shopId:0,
							"name":"超级塔克",
							"descibe":"超级塔克，营养丰富，口感好",
							"price":"30"
						},{
							shopId:1,
							"name":"超级汉堡",
							"descibe":"超级汉堡，营养丰富",
							"price":"20"
						}]
					},{
						type:"主食",
						typeId:1,
						shop:[{
							shopId:2,
							"name":"米饭",
							"descibe":"选择大山深处纯天然米饭",
							"price":"30"
						},{
							shopId:3,
							"name":"菜",
							"descibe":"各式各样的菜",
							"price":"22"
						}]
					},{
						type:"小食甜点",
						typeId:2,
						shop:[{
							shopId:4,
							"name":"草莓派",
							"descibe":"酸甜可口，满足",
							"price":"30"
						},{
							shopId:5,
							"name":"菠萝派",
							"descibe":"菠萝派，非常好吃的",
							"price":"15"
						},{
							shopId:6,
							"name":"香蕉派",
							"descibe":"香蕉派，纯香蕉",
							"price":"10"
						}]
					}
				]
			}
		},
		computed:{
			goodTypeNum() {
				return (tid) => { return this.cart.reduce((acc, cur)=> {
						if (cur.typeId == tid){
							return acc += cur.num
						}
						return acc
					}, 0)
				}
			},
			totalPrice(){	
				return this.cart.reduce((acc, cur) => acc + cur.num * cur.price, 0);
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
		onReady(){
			this.getAllGoodsHeight();
		},
		components: {
			uniNoticeBar,
			uniPopup,
			uniPopupMessage,
			uniPopupDialog
		},
		methods:{
			setId(index){
				this.viewId = "g" + index;
				this.currentType = index;
			},
			srollSetMenu(ev){
				let goodsScrollTop = ev.detail.scrollTop;
				//console.log("goodsScrollTop" + goodsScrollTop);
				for(let i = 0; i < this.goodsHeight.length; i++){
					// console.log(this.goodsHeight[i]);
					// console.log(this.goodsHeight[i + 1]);
					if(this.goodsHeight[i] < goodsScrollTop && this.goodsHeight[i + 1] > goodsScrollTop){
						this.currentType = i;
						//console.log(this.currentType);
					}
				}
			},
			getAllGoodsHeight(){
				let h = 0;
				this.goodsHeight.push(0);
				let views = uni.createSelectorQuery().selectAll(".goods").boundingClientRect().exec(res=>{
					//console.log(res);
					res[0].forEach(item=>{
						h += item.height;
						//console.log(h);
						this.goodsHeight.push(h);
					})
				})
			},
			goOrder(){
				
			},
			addCart(item, goods, num){
				// console.log("addCart item:" + item.shop);
				// console.log("addCart goods:" + goods);
				this.isShow = true;
				let index = this.cart.findIndex(it=>{
					return it.id == goods.shopId;
				});
				//console.log("addCart:" + index);
				if (index > -1){
					this.cart[index].num += num;
				}else{
					this.cart.push({
						id:goods.shopId,
						name:goods.name,
						typeId:item.typeId,
						num:num,
						price:goods.price
					})
				}
			},
			popAddCart(id, num){
				let index = this.cart.findIndex(it=> it.id == id);
				if (index > -1){
					this.cart[index].num += num;
				}
			},
			decCart(item, goods){
				let index = this.cart.findIndex(item => item.id == goods.shopId);
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
		width: 100%;
		height: 100%;
	}
	.top{
		height: 100rpx;
		box-shadow: 0 0rpx 20rpx 10rpx rgba(51, 51, 51, 0.1);
		border-radius: 5%;
		position: relative;
		margin-top: 120rpx;
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
			color: #C0C0C0;
			font-size: 25rpx;
			margin-left: 50rpx;
			margin-top: 40rpx;
		}
	}
	.mid-body{
		margin-top: 20rpx;
		padding-left: 20rpx;
		padding-right: 20rpx;
	}
	.cart-body{
		height: 715rpx;
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
					font-weight: 500;
					margin-bottom: 20rpx;
					color: #999999;
				}
				.one-goods{
					height: 210rpx;
					border-radius: 5%;
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
							width: 100%;
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
		width: 100%;
		height: 100rpx;
		background-color: #f1c40f;
		position: fixed;
		bottom: 0rpx;
		display: flex;
		flex-direction: row;
		.carticon{
			position: relative;
			image{
				width: 150rpx;
				height: 150rpx;
				position: absolute;
				top: -60rpx;
				left: 0rpx;
			}
		}
		.cartTitle{
			height: 100%;
			display: flex;
			align-items: center;
			margin-left: 150rpx;
			font-weight: 500;
			font-size: 40rpx;
		}
		.toOrder{
			position: absolute;
			font-weight: 500;
			font-size: 40rpx;
			color: #FFFFFF;
			background-color: #2f3542;
			width: 200rpx;
			right: 0rpx;
			height: 100%;
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: center;
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
	.popoup{
		height: 500rpx;
		width: 100%;
		background-color: #FFFFFF;
		margin-bottom: 100rpx;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
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
			.oneContent{
				height: 80rpx;
				width: 100%;
				display: flex;
				flex-direction: row;
				justify-content: space-between;
				align-items: center;
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
</style>
