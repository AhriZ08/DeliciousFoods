<template>
	<view class="container">
		<view class="detatilBody-f">
			<view class="location">成都信息工程大学航空港校区学生公寓18栋</view>
			<view class="LocaInfo">
				<text class="name">张先生</text>
				<text class="tel">123456789</text>
			</view>
			<view class="iconfont icon-yes checkYes"></view>
			<view class="iconfont icon-modefy modefy" @click="toAddAddr(0)"></view>
		</view>
		<view class="addAddr" @click="toAddAddr(1)">
			<view class="iconfont icon-addAddr addrIcon"></view>
		</view>
	</view>
</template>

<script>
	export default{
		methods:{
			toAddAddr(ops){
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/addr/updateAddr?ops='+ops
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
			margin: 20rpx 20rpx 10rpx 80rpx;
		}
		.LocaInfo{
			margin: 0 0 30rpx 80rpx;
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
		left: 20rpx;
		bottom: 80rpx;
		font-size: 30rpx;
		color: #f07373;
	}
	.modefy{
		position: absolute;
		right: 20rpx;
		bottom: 20rpx;
		font-size: 45rpx;
		width: 60rpx;
		height: 60rpx;
	}
	.addAddr{
		width: 700rpx;
		height: 130rpx;
		border-radius: 20rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		.addrIcon{
			font-size: 50rpx;
			color: #777777;
		}
	}
</style>
