<template>
	<view class="main">
		<!-- 地图区 -->
		<view class="map">	
				我是地图
		</view>
		<!-- 搜索区 -->
		<view class="serch">我是搜索区</view>
		<!-- 轮播图 -->
		<view class="scroll">我是轮播图</view>
		<!-- 分类区 -->
		<view class="sort">我是分类</view>
		<!-- 推荐区 -->
		<view class="commend">我是推荐区</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {

		}
	}
</script>

<style lang="scss">
	.main{text-align: center;
	}
	.map{
		width: 750rpx;
		height: 100rpx;
		border: #333333 2rpx solid;
	}
	.serch{
		width: 750rpx;
		height: 130rpx;
		border: #333333 2rpx solid;
	}
	.scroll{
		width: 750rpx;
		height: 280rpx;
		border: #333333 2rpx solid;
	}
	.sort{
		width: 750rpx;
		height: 200rpx;
		border: #333333 2rpx solid;
	}
	.commend{
		width: 750rpx;
		height: auto;
		border: #333333 2rpx solid;
	}
</style>
