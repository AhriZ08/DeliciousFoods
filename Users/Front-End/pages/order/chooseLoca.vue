<template>
	<view class="container">
		<view class="detatilBody-f">
			<view class="location">成都信息工程大学航空港校区学生公寓18栋</view>
			<view class="LocaInfo">
				<text class="name">张先生</text>
				<text class="tel">123456789</text>
			</view>
			<view class="iconfont icon-yes checkYes"></view>
		</view>
	</view>
</template>

<script>
</script>

<style lang="scss">
	page{
		background-color: #f2f2f2;
	}
	.container{
		overflow: hidden;
		position: relative;
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
		.location{
			font-size: 35rpx;
			font-weight: 550;
			margin: 20rpx;
		}
		.LocaInfo{
			margin: 0 0 30rpx 20rpx;
			color: #777777;
			font-size: 26rpx;
			width: 300rpx;
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			align-items: center;
		}
	}
	.behindSpline{
		width: 650rpx;
		height: 2rpx;
		background-color: #f2f2f2;
		margin: 10rpx auto 20rpx auto;
	}
	.checkYes{
		position: absolute;
		right: 30rpx;
		bottom: 30rpx;
		font-size: 30rpx;
	}
</style>
