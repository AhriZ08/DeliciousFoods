<template>
	<view class="container">
		<view class="service">	
			<view class="option" @click="toChangeTel">
				<view>更改手机号</view>
				<text class="iconfont icon-jiantou op-tail-icon"></text>
			</view>
			<view class="behindSpline"></view>
			<view class="option" @click="toChangePwd">
				<view>更改密码</view>
				<text class="iconfont icon-jiantou op-tail-icon"></text>
			</view>
			<view class="behindSpline"></view>
			<button plain="true" @click="quitApp">退出登录</button>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				userID:''
			}
		},
		methods:{
			toChangeTel(){
				uni.navigateTo({
					url: 'changeTel'
				});
			},
			toChangePwd(){
				uni.navigateTo({
					url: 'changePwd'
				});
			},
			quitApp(){
				uni.showLoading({title:'加载中'});
				uni.setStorageSync("userID","");
				uni.hideLoading();
				uni.switchTab({
					url:'/pages/info/personal'
				})
			}
		}
	}
</script>

<style lang="scss">
	.service{
		position: relative;
		display: flex;
		flex-direction: column;
		border-radius: 8rpx;
		margin-top: 50rpx;
		margin-bottom: 30rpx;
		width: 100%;
		background-color: #FFFFFF;
		.a-line{
			width: 100%;
			height: 2rpx;
			background-color: #C0C0C0;
		}
		.option{
			display: flex;
			flex-direction: row;
			align-items: center;
			position: relative;
			margin: 10rpx;
			color: #777777;
			height: 60rpx;
			.op-tail-icon{
				position: absolute;
				font-size: 40rpx;
				right: 10rpx;
			}
			view{
				margin-left: 20rpx;
			}
		}
		button{
			background-color: #e74c3c;
			color: #FFFFFF;
			height: 80rpx;
			width: 350rpx;
			margin: 10rpx auto 25rpx auto;
			border-radius: 10rpx;
			font-size: 32rpx;
			line-height: 78rpx;
			border: 2rpx solid #f07373;
		}
	}
	.behindSpline{
		width: 700rpx;
		height: 2rpx;
		background-color: rgba(192, 192,192, 0.2);
		margin: 10rpx auto 20rpx auto;
	}
</style>
