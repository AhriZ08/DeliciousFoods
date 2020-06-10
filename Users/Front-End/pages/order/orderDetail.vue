<template>
	<view class="container">
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>商品列表</view>
			<view class="behindSpline"></view>
			<view class="shopName">{{detail.shop_Name}}</view>
			<view class="cartList">
				<view class="oneCartGoods" v-for="(item, index) in detail.trollyList" :key="index">
					<view class="leftGoodsImg">
						<image :src="item.menu_Photo"></image>
					</view>
					<view class="rightContent">
						<text style="font-size: 35rpx;">{{item.menu_Name}}</text>
						<text style="color: #999999;font-size: 32rpx;">×{{item.trolly_Num}}</text>
						<view class="goodsCost">￥{{item.trolly_Price}}</view>
					</view>
				</view>
			</view>
			<view class="behindSpline"></view>
			<view class="totalMon">实付<text style="color: #DD524D;margin-left: 10rpx;">￥{{detail.order_Total}}</text></view>
		</view>
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>配送信息</view>
			<view class="behindSpline"></view>
			<view class="cartList">
				<view class="oneInfo">
					<view class="infoName">配送时间</view>
					<view class="runInfo">{{detail.order_SpendTime}}</view>
				</view>
				<view class="oneInfo">
					<view class="infoName">配送地址</view>
					<view class="runInfo">{{detail.order_RecAddr}}</view>
				</view>
			</view>
		</view>
		
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>订单信息</view>
			<view class="behindSpline"></view>
			<view class="cartList">
				<view class="oneInfo">
					<view class="infoName">订单号</view>
					<view class="runInfo">{{detail.order_FormatNum}}</view>
				</view>
				<view class="oneInfo">
					<view class="infoName">支付方式</view>
					<view class="runInfo">{{payType}}</view>
				</view>
				<view class="oneInfo">
					<view class="infoName">下单时间</view>
					<view class="runInfo">{{detail.order_Time}}</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				detail:{},
				orderDetailID:'',
				payType:''
			}
		},
		onLoad(option) {
			this.orderDetailID = option.orderID;
			uni.showLoading({title:'加载中'});
			this.initOneOrderDetail();
			
		},
		methods:{
			async initOneOrderDetail(){
				var that = this;
				await uni.request({
					url:"http://47.112.243.221:8080/dFoods/user/order/detail/"+that.orderDetailID,
					method:'GET',
					success: (res) => {
						console.log(res.data);
						uni.hideLoading();
						that.detail = res.data;
						if (res.data.order_PayType == 0){
							that.payType = '余额支付';
						}else if (res.data.order_PayType == 1){
							that.payType = '微信支付';
						}else if (res.data.order_PayType == 2){
							that.payType = '支付宝';
						}
					},
					fail: () => {
						uni.hideLoading();
						uni.showToast({
							title:'获取订单详情失败！',
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
		color: #777777;
	}
	.detatilBody-f{
		width: 700rpx;
		border-radius: 30rpx;
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
			color: #f07373;
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
		margin:0 25rpx 20rpx 0;
		align-self: flex-end;
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
		margin: 0rpx auto 0rpx auto;
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
					font-size: 30rpx;
				}
			}
		}
		.oneInfo{
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: space-between;
			font-size: 26rpx;
			margin: 0rpx 5rpx 20rpx 5rpx;
			.runInfo{
				text-align: right;
			}
		}
	}
</style>
