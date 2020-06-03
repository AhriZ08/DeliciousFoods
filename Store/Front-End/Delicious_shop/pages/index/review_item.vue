<template>
	<view class="content">
		<view class="content_review">
			<!-- 回复界面-->
			<view class="up">
				<view class="user">
					<image src="../../static/Resource_review/个人头像.jpg" class="head" style="float: left;"></image>
					<view><text>{{user.in_content}}</text></view>
				</view>
				<view class="shop">
					<image src="../../static/Project4Resource/正新鸡排图标.jpg" class="head"style="float: right;" ></image>
					<view><text>{{shop.out_content}}</text></view>
				</view>
			</view>
			<!-- 输入信息-->
			<view class="in">
				<input type="text" focus="" value="" />
				<button type="default"> 确定</button>
			</view>
		</view>
	</view>
	
</template>

<script>

	export default {
		data() {
			return {						  
				user:{
					head_address:"",
					in_content:"默认好评啊啊啊啊啊啊啊啊长宽比吧哭吧哭吧可算把biubiu爱步",
					},
				shop:{
					head_address:"",
					out_content:"笔芯oks",						
					}
				,
				
				
			}
		},
		methods: {
		}
	}
</script>

<style>
	.content{
		background-color: #EEEEEE;
	}
	.content_review{
		display: flex;
		flex-direction: column;
		width: 90%;
		margin:auto;
		background-color: ;
	}
	.head{
		width:100rpx;
		height: 100rpx;
		border-radius: 50rpx;
	}
	.user{
		margin-top: 20rpx;
	}
	
	.user view{
		background-color: #FFFFFF;
		margin-left: 110rpx;
		margin-right: 20rpx;
		font-size: normal;
		border: #808080 3rpx;
		border-style: groove;
		padding-left: 10rpx;
		border-radius: 20rpx;
	}
	.shop{
		margin-top: 40rpx;
	}
	.shop view{
		background-color: #FFFFFF;
		margin-right: 20rpx;
		margin-left: 20rpx;
		font-size: normal;
		border: #808080 3rpx;
		border-style: groove;
		padding-right: 10rpx;
		border-radius: 20rpx;
		float: right;

	}
	.up{
		background-color: #FFFFFF;
		padding-bottom: 500rpx;
	}
	.in{
		margin-top: 50rpx;
		padding-top: 20rpx;
		padding-bottom: 10rpx;
	}
	.in input{
		background-color:#DCDCDC;
	}
</style>
