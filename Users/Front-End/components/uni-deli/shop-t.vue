<template>
	<view>
		<view class="shop-item" @click="opens">
			<!-- 店铺图 -->
			<view class="shop-img">
				<image src="https://upload.wikimedia.org/wikipedia/zh/thumb/b/bf/Starbucks_Coffee.svg/200px-Starbucks_Coffee.svg.png" style="width: 100%;height: 100%;"></image>
			</view>
			<!-- 店铺信息 -->
			<view class="shop-ii">
				<!-- 名字 -->
				<view class="shop-title">
					<view>
						星巴克星专送
					</view>
				</view>
				<!-- 配送信息 -->
				<view class="shop-info">
					<view class="shop-info1">
						<view class="shop-ip">
							<image src="../../static/icon/index/main/color/星星.png" style="width: 40rpx; height: 40rpx;"></image>
							<view style="color: #d81e06;">4.8</view>
							<text style="margin-left: 7rpx;">月售:2300</text>
						</view>
						<view>30分钟 2km </view>
					</view>
					<view class="shop-info2">
						<view>起送￥20</view>
						<view style="margin-left: 15rpx;">配送￥2</view>
						<view style="margin-left: 15rpx;">人均￥30</view>
					</view>
					<!-- 店铺类型 -->
					<view class="shop-sort" >
						<image src="../../static/icon/index/main/店铺.png" style="width: 40rpx; height: 40rpx;"></image>
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
		},
		methods:{
			opens(){
				uni.navigateTo({
					url: '../../pages/cart/cart',
					success: res => {},
					fail: (e) => {console.log(e);},
					complete: () => {}
				});
			}
		}
	}
</script>

<style lang="scss">
	.shop-item{
		display: flex;
		margin-top: 30rpx;
		width: 730rpx;
		.shop-img{
			width: 200rpx;
			height: 200rpx;
			border: #AAAAAA 2rpx solid; 
			border-radius: 8rpx;
			image{
				width: 100%;
				height: 100%;
			}
		}
		.shop-ii{
			margin-left: 14rpx;
			width: 530rpx;
			.shop-title{
				font-size: 45rpx;
				font-weight: 500;
				margin-top: -10rpx;
				margin-left: 3rpx;
			}
			.shop-info{
				margin-top: 5rpx;
				margin-left: -5rpx;
				color: #718093;
				.shop-info1{
					display: flex;
					justify-content: space-between;
					.shop-ip{
						display: flex;
						align-items: center;
						justify-content: center;
						padding: 2rpx 7rpx;
					}
				}
				.shop-info2{
					display: flex;
					align-items: center;
					padding: 2rpx 7rpx;
					margin-top: 9rpx;
					margin-left: 3rpx;
				}
				.shop-sort{
					display: flex;
					align-items: center;
					padding: 2rpx 7rpx;
					margin-top: 10rpx;
					border-bottom: 1px #dcdde1 solid;
				}
			}
		}
	}
</style>
