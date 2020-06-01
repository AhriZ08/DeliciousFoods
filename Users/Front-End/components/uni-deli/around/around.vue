<template>
	<view class="tt">
		<!-- 文字 -->
		<view style="text-align: center;border-bottom: 1rpx #888888 solid; ">
			<text style="font-size: 70rpx;color: #a5b1c2;">推荐店铺</text>
		</view>
		<!-- 店铺块 -->
		<view class="shop-item">
			<!-- 店铺图 -->
			<view class="shop-img" style="border: #AAAAAA 2rpx solid; border-radius: 8rpx;">
				<image src="http://spider.ws.126.net/8c8e5ea5ff69dc34ff8824e1d6f6533d.jpeg" style="width: 100%;height: 100%;"></image>
			</view>
			<!-- 店铺信息 -->
			<view class="shop-ii" style="padding-left: 15rpx;margin-top: -10rpx;">
				<!-- 名字 -->
				<view class="shop-title" style="font-size: 50rpx;font-weight: 500; color: #222f3e;">星巴克星专送</view>
				<!-- 配送信息 -->
				<view class="shop-info" style="padding: 10rpx 0;border-bottom: 1rpx #BBBBBB solid;color: #636e72;">
					<view style="display: flex;width: 500rpx;">
						<image src="../../../static/icon/index/main/color/星星.png" style="width: 30rpx;height: 30rpx;margin-top: 6rpx;"></image>
						<view style="color: #E03A24;">4.8</view>
						<text space="emsp">月售:2300</text>
						<view style="margin-left: 100rpx;"> 30分钟 2km </view>
					</view>
					<view style="display: flex;">
						<view>起送￥20</view>
						<view style="margin-left: 15rpx;">配送￥2</view>
						<view style="margin-left: 15rpx;">人均￥30</view>
					</view>
					<view class="shop-sort" style="display: flex;margin-top: 15rpx;">
						<image src="../../../static/icon/index/main/店铺.png" style="width: 30rpx;height: 30rpx;margin-top: 6rpx;"></image>
						<text >甜品饮品</text>
					</view>
				</view>

			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
	.tt{margin-top: 10rpx;}
	.shop-item{
		display: flex;
		margin-top: 30rpx;
		width: 730rpx;
		height: 2000rpx;
		.shop-img{
			width: 200rpx;
			height: 200rpx;
		}
	}
</style>
