<template>
	<view>
		<view class="sort">
			<!-- 美食 -->
			<view class="sort-item" >
				<view class="sort-img1">
					<image src="../../static/icon/index/main/color/美食.png" mode="widthFix"></image>
				</view>
				<text>美食</text>
			</view>
			<!-- 超商 -->
			<view class="sort-item">
				<view class="sort-img2">
					<image src="../../static/icon/index/main/color/超市.png" mode="widthFix" style="width: 65%; height: 65%; margin-top: 15%;"></image>
				</view>
				<text>超商便利</text>
			</view>
			<!-- 水果 -->
			<view class="sort-item">
				<view class="sort-img3">
					<image src="../../static/icon/index/main/color/水果苹果.png" mode="widthFix" ></image>
				</view>
				<text>水果</text>
			</view>
			<!-- 送药上门 -->
			<view class="sort-item">
				<view class="sort-img4">
					<image src="../../static/icon/index/main/color/药店.png" mode="widthFix"></image>
				</view>
				<text>送药上门</text>
			</view>
			<!-- 饮品 -->
			<view class="sort-item">
				<view class="sort-img5">
					<image src="../../static/icon/index/main/color/饮品.png" mode="widthFix"></image>
				</view>
				<text>甜品饮品</text>
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

<style lang="scss" scoped>
	.sort{margin-top: 20rpx;display: flex;margin-bottom: 30rpx;}
	.sort-item{text-align: center;margin-left: 22rpx;}
	.sort-item image{width: 70%;height: 70%;margin-top: 15%;}
	.sort text{font-size: 30rpx;}
	.sort-img1{background-color: #D9001B;width: 120rpx;height: 120rpx;border-radius: 50%;}
	.sort-img2{background-color: #027DB4;width: 120rpx;height: 120rpx;border-radius: 50%;}
	.sort-img3{background-color: #F59A23;width: 120rpx;height: 120rpx;border-radius: 50%;}
	.sort-img4{background-color: #00BFBF;width: 120rpx;height: 120rpx;border-radius: 50%;}
	.sort-img5{background-color: #EC808D;width: 120rpx;height: 120rpx;border-radius: 50%;}
</style>
