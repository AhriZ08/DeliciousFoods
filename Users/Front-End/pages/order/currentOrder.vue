<template>
	<view class="container">
		<view class="step-container">
			<view :class="order.order_State=='已下单'?'status selected':'status'">
				<view class="iconfont icon-order statusIcon"></view>
				<view class="statusCont">已下单</view>
			</view>
			<view :class="order.order_State=='配送中'?'status selected':'status'">
				<view class="iconfont icon-runorder statusIcon"></view>
				<view class="statusCont">配送中</view>
			</view>
			<view :class="order.order_State=='待收货'?'status selected':'status'">
				<view class="iconfont icon-overorder statusIcon"></view>
				<view class="statusCont">已签收</view>
			</view>
			<view class="line-f line"></view>
			<view class="line-s line"></view>
		</view>
		<view class="cart-container">
			<view class="shopName">{{order.shop_Name}}</view>
			<view class="behindSpline"></view>
			<view class="cartList">
				<view class="oneCartGoods" v-for="(item, index) in order.trollyList" :key="index">
					<view class="leftGoodsImg">
						<image :src="item.menu_Photo"></image>
					</view>
					<view class="rightContent">
						<text style="font-size: 35rpx;">{{item.menu_Name}}</text>
						<text style="color: #999999;font-size: 26rpx;">×{{item.trolly_Num}}</text>
						<view class="goodsCost">￥{{item.trolly_Price}}</view>
					</view>
				</view>
			</view>
			<view class="behindSpline"></view>
			<view class="runCost">
				<text>配送费</text>
				<text style="color: #DD524D;font-weight: 550;font-size: 26rpx;">￥{{order.shop_RunCost}}</text>
			</view>
		</view>
		<view class="detail-container">
			<view class="behindSpline"></view>
			<view class="oneDet">
				<view class="payTypeTitle">支付方式</view>
				<view class="payType">{{payType}}</view>
			</view>
			<view class="oneDet">
				<view class="payTypeTitle">总金额</view>
				<view class="payType">￥{{order.order_Total}}</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default{
		data() {
			return{
				order:{},
				orderID:'',
				payType:''
			}
		},
		onLoad(option) {
			this.orderID = option.orderID;
			uni.showLoading({title: '加载中'});
			this.initOneOrder();
			uni.hideLoading();
		},
		onPullDownRefresh() {
			this.initOneOrder();
			uni.stopPullDownRefresh();
		},
		methods:{
			async initOneOrder(){
				var that = this
				await uni.request({
					url:"http://localhost:8080/dFoods/user/order/one/"+that.orderID,
					method:'GET',
					success: (res) => {
						that.order = res.data;
						if (res.data.order_PayType == 0){
							that.payType = '余额支付';
						}else if (res.data.order_PayType == 1){
							that.payType = '微信支付';
						}else if (res.data.order_PayType == 2){
							that.payType = '支付宝';
						}
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
	.shopName{
		font-size: 35rpx;
		font-weight: 550;
		font-family: Arial, Helvetica, sans-serif;
		margin: 20rpx 0rpx 10rpx 30rpx;
		letter-spacing: 3rpx;
	}
	.runCost{
		width: 650rpx;
		margin: 0rpx auto 20rpx auto;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}
	.behindSpline{
		width: 650rpx;
		height: 2rpx;
		background-color: rgba(192, 192,192, 0.3);
		margin: 10rpx auto 20rpx auto;
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
			margin: 0rpx 30rpx 15rpx 30rpx;
			.payTypeTitle{
				color: #AAAAAA;
			}
			.payType{
				font-weight: 520;
				color: #DD524D;
			}
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
	.selected{
		color: #f07373;
	}
</style>
