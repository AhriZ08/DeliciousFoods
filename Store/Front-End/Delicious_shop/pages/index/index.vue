<template>
	<view class="content">
		<!--第一行 店铺信息 -->
		<view class="Information_shop">		
			<image class="" src="../../static/Project4Resource/index_resource/正新鸡排图标.jpg" ></image>
			<text>正新鸡排</text>
			<text>查看店铺详情</text>
			<text>营业中></text>
					
		</view>
		
		<!--第二行 操作 -->
		<view class="opration">
			<view class="opration_item" style="border-right-color: #b2d9a1;border-right-width: 5rpx;border-right-style: groove;">
				<view class="iconfont icon-shangpin" style="color: #FFBB53;"></view>
				<text>商品</text>
			</view>
			<view class="opration_item" style="border-right-color: #b2d9a1;border-right-width: 5rpx;border-right-style: groove;">
				<view class="iconfont icon-pingjia" style="color: #FF9067;"></view>
				<text>评价</text>
			</view>
			<view class="opration_item" style="border-right-color: #b2d9a1;border-right-width: 5rpx;border-right-style: groove;">
				<view class="iconfont icon-caiwu" style="color: #43D48C;"></view>
				<text>财务</text>
			</view>
			<view class="opration_item">
				<view class="iconfont icon-icon--copy" style="color: #60BEF9;"></view>
				<text>订单</text>
			</view>
		</view>
		<!--第三行 经营数据 -->
		<view class="Turnover">
			<view class="Turnover_Head">
				<text>经营数据</text>
				<text>更多></text>
			</view>
			<view class="Turnover_content">
				<view class="Turnover_content_div">
					<text>今日营业额\n</text>
					<text>5280\n</text>
					<text>昨日 6280</text>
				</view>
				<view class="Turnover_content_div">
					<text>今日订单\n</text>
					<text>132\n</text>
					<text>昨日 120 单</text>
				</view>	
				<view class="Turnover_content_div">
					<text>客单价\n</text>
					<text>40\n</text>
					<text>昨日 56.8</text>
				</view>		
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style>
	@import url("/static/Project4Resource/index_resource/iconfont.css");
	.content {
		background-color:#d8d8d8;
	}
	.content text{
		font-size: large;
	}
	//第一行 店铺信息
	.Information_shop{
		width: 100%;
		height: 400rpx;
		border-color:#999999;
		border-style:double;
		border-size:10rpx;
		background-color:#0091EB;	
	}
	.Information_shop image{
		border: 10rpx;
		border-style: inset;
		margin-left: 30rpx;
		width: 200rpx;
		height: 200rpx;
		position: absolute;
		margin-top: 100rpx;
	}
	.Information_shop text{
		position: absolute;

	}
	.Information_shop text:nth-child(2){
		margin-top: 120rpx;
		margin-left: 300rpx;
		color:#F8F8F8;
		
	}
	.Information_shop text:nth-child(3){
		margin-top: 260rpx;
		margin-left: 300rpx;
		font-weight: 50;
		}
	.Information_shop text:nth-child(4){
		margin-top: 260rpx;
		margin-left: 600rpx;
		background-color: #007AC7;
		border-radius: 20rpx;
		color:#F8F8F8;
	}

	//第二行 店铺操作
	.opration{
		background-color: #F8F8F8;
		display: flex;
		margin-top: 40rpx;
		border-color:#FFFFFF;
		border-style:double;
		border-size:10rpx;
	}
	
	.opration_item{
		width: 25%;
		text-align: center;
	}
	.opration_item view{
		font-size: 100rpx;
		text-align: center;
		margin: 0rpx auto;
		border-style: none;
	}
	
	.opration_item text{
		margin-top: 0rpx;
		}
		
		
	//第三行 经营数据
	
	
	.Turnover{
		margin-top: 40rpx;
		background-color: #F8F8F8;
		border-color: #FFFFFF;
		border-style:double;
		border-size:10rpx;
	}
	.Turnover_Head{
		
		border-bottom-color: #999999;
		border-bottom-width: 5rpx;
		border-bottom-style: groove;

		
	}
	.Turnover_Head text:nth-child(2){
		font-weight: 50;
		font-size:x-large;
		float: right;
	}
	.Turnover_Head text:nth-child(1){
		font-weight: 500;
		font-size:x-large;
	}
	
	.Turnover_content{
		display: flex;
		width: 100%;
		padding-top: 20rpx;
	}
	.Turnover_content view:nth-child(1){
		border-right-color: #b2d9a1;
		border-right-width: 
		5rpx;border-right-style: groove;
	}
	.Turnover_content view:nth-child(2){
		border-right-color: #b2d9a1;
		border-right-width: 5rpx;
		border-right-style: groove;
	}
	.Turnover_content_div
	{
		width: 33%;
		flex-direction: column;
		text-align: center;
	}
	.Turnover_content_div text:nth-child(2)
	{
		font-weight: 600;
	}
	.Turnover_content_div text:nth-child(3)
	{
		font-weight: 50;
	}
</style>
