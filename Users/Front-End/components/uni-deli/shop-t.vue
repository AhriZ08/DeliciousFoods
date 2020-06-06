<template>
	<view>
		<view class="shop-item" @click="opens">
			<!-- 店铺图 -->
			<view class="shop-img">
				<image :src=shoptl.shop_Image style="width: 100%;height: 100%;"></image>
			</view>
			<!-- 店铺信息 -->
			<view class="shop-ii">
				<!-- 名字 -->
				<view class="shop-title">
					<view>
						{{shoptl.shop_Name}}
					</view>
				</view>
				<!-- 配送信息 -->
				<view class="shop-info">
					<view class="shop-info1">
						<view class="shop-ip">
							<image src="../../static/icon/index/main/color/星星.png" style="width: 40rpx; height: 40rpx;"></image>
							<view style="color: #d81e06;">{{shoptl.shop_Qrade}}</view>
							<text style="margin-left: 7rpx;">月售:{{shoptl.shop_SellTotall}}</text>
						</view>
						<view>{{shoptl.shop_Distance}}</view>
					</view>
					<view class="shop-info2">
						<view>起送￥{{shoptl.shop_RunStartCost}}</view>
						<view style="margin-left: 15rpx;">配送￥{{shoptl.shop_RunCost}}</view>
						<view style="margin-left: 15rpx;">人均￥{{shoptl.shop_AvgCost}}</view>
					</view>
					<!-- 店铺类型 -->
					<view class="shop-sort" >
						<image src="../../static/icon/index/main/店铺.png" style="width: 40rpx; height: 40rpx;"></image>
						<text>{{shoptl.shop_Sort}}</text>
					</view>
				</view>
		
			</view>
		</view>
	</view>
</template>

<!-- shoptl.shop_Image 照片
shoptl.shop_AvgCost 平均花费
shoptl.shop_Image 店铺照片
shoptl.shop_Name 店铺名
shoptl.shop_Qrade 评分
shoptl.shop_RunCost 配送费
shoptl.shop_RunStartCost 起送价
shoptl.shop_Sort 分类
shoptl.shop_SellTotall 总计销售量
shoptl.shop_Distance 配送距离 -->

<script>
	export default {
		data() {
			return {
				
			};
		},
		methods:{
			opens(){
				uni.navigateTo({
					url: '../../pages/cart/cart?sid='+shoptl.shop_ID,
					success: res => {},
					fail: (e) => {console.log(e);},
					complete: () => {}
				});
			}
		},
		props:['shoptl']
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
