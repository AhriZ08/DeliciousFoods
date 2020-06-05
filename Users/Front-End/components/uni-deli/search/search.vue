<template>
	<view>
		<!-- 定位 -->
		<view class="search-view">
			<image src="../../../static/icon/index/main/color/定位.png" mode="widthFix"></image>
			<text class="search-text">成都信息工程大学</text>
			<text>></text>
		</view>
		<!-- 搜索框 -->
		<view class="search-cont">
			<view class="search" @click="seaRch">
				<image src="../../../static/icon/index/main/搜索.png" mode="widthFix" class="search-img"></image>
				<input type="text" placeholder="茶百道" disabled/>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		},
		methods:{
			seaRch(){
				uni.navigateTo({
					url: '../../pages/index/main-search',
					success: res => {},
					fail: (e) => {console.log(e);},
					complete: () => {}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.search-view image{
		width: 40rpx;
		height: 40rpx;
	}
	.search-view{font-size: 40rpx;display: flex;height: 125rpx;align-items: center;}
	.search-text{padding: 0 10rpx;}
	.search-img{margin: auto 0 auto 20rpx;width: 60rpx; height: 60rpx;}
	.search{
		height: 85rpx;
		width: 100%;
		display: flex;
		background-color: #d1d8e0;
		border-radius: 50rpx;
		font-size: 28rpx;
		align-items: center;

	}
	.search-cont{
		display: flex;
		justify-content: space-between;
	}
	
</style>
