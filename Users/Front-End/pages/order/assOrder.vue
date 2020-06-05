<template>
	<view class="container">
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>商品列表</view>
			<view class="behindSpline"></view>
			<view class="shopName">星巴克</view>
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
			<view class="behindSpline"></view>
			<view class="totalMon">实付<text style="color: #DD524D;margin-left: 6rpx;">￥150.00</text></view>
		</view>
		<view class="detatilBody-f">
			<view class="bodyTitle"><view class="tag"></view>评价</view>
			<view class="behindSpline"></view>
			<view class="assStars">
				<label>星级评定</label>
				<uni-rate value="5" size="15"></uni-rate>
			</view>
			<view class="assInput">
				<view class="inputTitle">您的评价</view>
				<textarea placeholder="请输入内容"/>
				<button plain="true">提交</button>
			</view>
		</view>
	</view>
</template>

<script>
	import uniRate from '@/components/uni-rate/uni-rate.vue'
	export default {
	    components: {
			uniRate
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
			font-size: 40rpx;
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
		margin: 0rpx 0rpx 10rpx 25rpx;
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
		margin: 0rpx auto 20rpx auto;
		.oneGoods{
			font-size: 26rpx;
			display: flex;
			flex-direction: row;
			position: relative;
			margin-bottom: 10rpx;
			justify-content: flex-start;
			align-items: center;
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
		.oneInfo{
			font-size: 26rpx;
			display: flex;
			flex-direction: row;
			position: relative;
			margin-bottom: 20rpx;
			justify-content: space-between;
			.runInfo{
				text-align: right;
				width: 400rpx;
				color: #AAAAAA;
			}
		}
	}
	.assInput{
		display: flex;
		flex-direction: column;
		margin: 0 20rpx 20rpx 20rpx;
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
			width: 630rpx;
		}
	}
	.assStars{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		margin: 0 20rpx 20rpx 20rpx;
	}
</style>
