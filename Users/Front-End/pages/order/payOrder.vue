<template>
	<view class="container">
		
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>配送信息</view>
			<view class="behindSpline"></view>
			<view class="locationView" @click="toChooseLoca">
				<view class="title">姓名<view class="nextTitle">美食家</view></view>
				<view class="title">地址<view class="nextTitle">成都信息工程大学航空港校区学生公寓18栋</view></view>
			</view>
			<view class="iconfont icon-jiantou selectLocation"></view>
		</view>
		
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>商品列表</view>
			<view class="behindSpline"></view>
			<view class="shopName">星巴克</view>
			<view class="cartList">
				<view class="oneCartGoods">
					<view class="leftGoodsImg">
						<image src="../../static/icon/index/main/cart/logo.png"></image>
					</view>
					<view class="rightContent">
						<text style="font-size: 35rpx;">超级塔克</text>
						<text style="color: #999999;font-size: 26rpx;">×2</text>
						<view class="goodsCost">￥150.00</view>
					</view>
				</view>
				
				<view class="oneCartGoods">
					<view class="leftGoodsImg">
						<image src="../../static/icon/index/main/cart/logo.png"></image>
					</view>
					<view class="rightContent">
						<text style="font-size: 35rpx;">超级塔克</text>
						<text style="color: #999999;font-size: 26rpx;">×2</text>
						<view class="goodsCost">￥30.00</view>
					</view>
				</view>
				
				<view class="oneCartGoods">
					<view class="leftGoodsImg">
						<image src="../../static/icon/index/main/cart/logo.png"></image>
					</view>
					<view class="rightContent">
						<text style="font-size: 35rpx;">超级塔克</text>
						<text style="color: #999999;font-size: 26rpx;">×2</text>
						<view class="goodsCost">￥50.00</view>
					</view>
				</view>
			</view>
		</view>
		
		<view class="detatilBody-f lastContainer">
			<view class="bodyTitle"><view class="tag"></view>支付方式</view>
			<view class="behindSpline"></view>
			<view class="payTypeSelc" @click="choosePayType(0)">
				<view :class="currentPayType==0?'payTypeSelcName selectdColor':'payTypeSelcName'" >
					<view class="iconfont icon-money moneyIcon"></view>
					余额付款
					<view :class="currentPayType==0?'iconfont icon-checked checkIcon':'iconfont icon-unchecked checkIcon'"></view>
				</view>
			</view>
			<view class="payTypeSelc" @click="choosePayType(1)">
				<view :class="currentPayType==1?'payTypeSelcName selectdColor':'payTypeSelcName'" >
					<view class="iconfont icon-weixin moneyIcon"></view>
					微信支付
					<view :class="currentPayType==1?'iconfont icon-checked checkIcon':'iconfont icon-unchecked checkIcon'"></view>
				</view>
			</view>
			<view class="payTypeSelc" @click="choosePayType(2)">
				<view :class="currentPayType==2?'payTypeSelcName selectdColor':'payTypeSelcName'" >
					<view class="iconfont icon-zhifubao moneyIcon"></view>
					支付宝
					<view :class="currentPayType==2?'iconfont icon-checked checkIcon':'iconfont icon-unchecked checkIcon'"></view>
				</view>
			</view>
		</view>
		
		<view class="bottom-pay">
			<view class="totalMon">
				合计
				<text style="color: #DD524D;margin-left: 6rpx;font-weight: 550;font-size: 35rpx;">
				￥150.00</text>
			</view>
			<view class="payView" @click="openOrder">付款</view>
			
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				currentPayType:0
			}
		},
		methods:{
			choosePayType(index){
				this.currentPayType = index;
			},
			toChooseLoca(){
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/addr/chooseLoca'
				});
				uni.hideLoading();
			},
			openOrder(){
				uni.switchTab({
					url:'order'
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
		color: #777777;
	}
	.detatilBody-f{
		width: 700rpx;
		border-radius: 20rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		position: relative;
		.bodyTitle{
			font-size: 35rpx;
			font-weight: 500;
			font-family: Arial, Helvetica, sans-serif;
			margin: 20rpx 0rpx 10rpx 30rpx;
			letter-spacing: 3rpx;
			display: flex;
			flex-direction: row;
			justify-content: flex-start;
			align-items: center;
			.tag{
				width: 10rpx;
				height: 42rpx;
				background-color: #f07373;
				border-radius: 30rpx;
				margin-right: 16rpx;
			}
		}
	}
	.shopName{
		font-size: 35rpx;
		font-weight: 550;
		font-family: Arial, Helvetica, sans-serif;
		margin: 0rpx 0rpx 10rpx 25rpx;
		letter-spacing: 3rpx;
	}
	.totalMon{
		font-size: 30rpx;
		margin:auto 0rpx auto 30rpx;
		align-self: flex-start;
		text-align: center;
		display: flex;
		align-items: center;
		justify-content: center;
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
	.locationView{
		margin: 0 20rpx 20rpx 20rpx;
		.title{
			font-size: 30rpx;
			margin-bottom: 20rpx;
			display: flex;
			flex-direction: row;
			justify-content: flex-start;
			align-items: flex-start;
			.nextTitle{
				color: #AAAAAA;
				width: 500rpx;
				margin-left: 20rpx;
			}
		}
	}
	.payTypeSelc{
		margin: 0 25rpx 25rpx 25rpx;
		.payTypeSelcName{
			font-size: 30rpx;
			margin-bottom: 20rpx;
			height: 30rpx;
			display: flex;
			flex-direction: row;
			justify-content: flex-start;
			align-items: center;
			position: relative;
		}	
	}
	.moneyIcon{
		font-size: 40rpx;
		margin-right: 10rpx;
	}
	.checkIcon{
		font-size: 32rpx;
		position: absolute;
		right: 0rpx;
	}
	.selectdColor{
		color: #f07373;
	}
	.bottom-pay{
		position: fixed;
		bottom: 0rpx;
		width: 100%;
		height: 100rpx;
		background-color: #FFFFFF;
		box-shadow: 0 10rpx 6rpx 6rpx rgba(51, 51, 51, 0.5);
		display: flex;
		flex-direction: row;
	}
	.lastContainer{
		margin-bottom: 120rpx;
	}
	.payView{
		height: 100%;
		width: 200rpx;
		position: absolute;
		right: 0rpx;
		background-color: #f07373;
		color: #FFFFFF;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	.selectLocation{
		position: absolute;
		right: 20rpx;
		font-size: 40rpx;
		bottom: 60rpx;
		color: #AAAAAA;
	}
</style>
