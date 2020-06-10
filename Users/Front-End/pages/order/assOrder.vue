<template>
	<view class="container">
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>商品列表</view>
			<view class="behindSpline"></view>
			<view class="shopName">{{curtorder.shop_Name}}</view>
			<view class="cartList">
				<view class="oneCartGoods" v-for="(item, index) in curtorder.trollyList" :key="index">
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
			<view class="runCost">
				<text>配送费</text>
				<text style="color: #DD524D;font-weight: 550;font-size: 26rpx;">￥{{curtorder.shop_RunCost}}</text>
			</view>
			<view class="behindSpline"></view>
			<view class="totalMon">实付<text style="color: #DD524D;margin-left: 6rpx;font-weight: 550;font-size: 26rpx;">￥{{curtorder.order_Total}}</text></view>
		</view>
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>评价</view>
			<view class="behindSpline"></view>
			<view class="assStars">
				<label>星级评定</label>
				<uni-rate size="15" v-model="putInfo.rate" @change="rate"></uni-rate>
			</view>
			<view class="assInput">
				<view class="inputTitle">您的评价</view>
				<textarea placeholder="请输入内容" v-model="putInfo.assContent"/>
				<button plain="true" @click="putAss">提交</button>
			</view>
		</view>
	</view>
</template>

<script>
	import uniRate from '@/components/uni-rate/uni-rate.vue'
	export default {
		data(){
			return{
				curtorder:{},
				putInfo:{
					rate:0,
					assContent:'',
					userID:'',
					shopID:'',
					orderID:''
				}
			}
		},
	    components: {
			uniRate
		},
		onLoad(option) {
			this.curtorder = JSON.parse(decodeURIComponent(option.curtorder));
		},
		methods:{
			rate(e){
				this.putInfo.rate = e.value;
			},
			putAss(){
				this.putInfo.userID = uni.getStorageSync('userID');
				this.putInfo.shopID = this.curtorder.shop_ID;
				this.putInfo.orderID = this.curtorder.order_ID;
				if (this.putInfo.assContent == '' || this.putInfo.assContent == null){
					uni.showToast({
						title:'请输入评价内容',
						position:'center',
						icon:'none'
					})
				}else {
					let data = JSON.stringify(this.putInfo);
					uni.showLoading({title:'加载中'});
					uni.request({
						url:"http://47.112.243.221:8080/dFoods/user/order/ass",
						method:'POST',
						data:data,
						success: (res) => {
							uni.hideLoading();
							if (res.data == "success"){
								uni.showToast({
									title:'评价成功！',
									position:'center',
								})
								uni.navigateBack();
							}else {
								uni.showToast({
									title:'评价失败！',
									position:'center',
									icon:'none'
								})
							}
						},fail: () => {
							uni.hideLoading();
							uni.showToast({
								title:'评价失败！',
								position:'center',
								icon:'none'
							})
						}
					})
				}
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
	.runCost{
		width: 650rpx;
		margin: 0rpx auto 10rpx auto;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		text{
			font-size: 26rpx;
		}
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
	.behindSpline{
		width: 650rpx;
		height: 2rpx;
		background-color: rgba(192, 192,192, 0.3);
		margin: 10rpx auto 20rpx auto;
	}
	.shopName{
		font-size: 35rpx;
		font-weight: 550;
		font-family: Arial, Helvetica, sans-serif;
		margin: 0rpx 0rpx 15rpx 25rpx;
		letter-spacing: 3rpx;
	}
	.totalMon{
		font-size: 26rpx;
		margin:0 25rpx 20rpx 0;
		align-self: flex-end;
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
					font-weight: 550;
					font-size: 26rpx;
				}
			}
		}
	}
	.assInput{
		display: flex;
		flex-direction: column;
		margin: 0 30rpx 20rpx 30rpx;
		.inputTitle{
			font-size: 30rpx;
		}
		button{
			display: inline-block;
			height: 60rpx;
			width: 160rpx;
			color: #f07373;
			margin-left: 20rpx;
			margin: 0rpx 10rpx 15rpx 0rpx;
			border-radius: 10rpx;
			font-size: 25rpx;
			line-height: 58rpx;
			border: 2rpx solid #f07373;
			align-self: flex-end;
		}
		textarea{
			height: 200rpx;
			border: 2rpx solid #AAAAAA;
			margin: 20rpx 0 30rpx 0;
			padding: 10rpx;
			width: 605rpx;
			font-size: 26rpx;
		}
	}
	.assStars{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		margin: 0 30rpx 20rpx 30rpx;
		label{
			font-size: 30rpx;
		}
	}
</style>
