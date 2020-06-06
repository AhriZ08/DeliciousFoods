<template>
	<view>
		<!-- 时间块 -->
		<view class="chat_time">
			<text>{{contents.time}}</text>
		</view>
		<!-- 聊天的内容 -->
		<view class="ttt">
			<view class="item_range">
				<view class="item_info">{{contents.content}}</view>
				<view class="item_tail"></view>
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
		props:["contents"]
	}
</script>

<style lang="scss" scoped>
	.chat_time{
		display: flex;
		justify-content: center;
		align-items: center;
		color: #718093;
		font-size: 25rpx;
		padding: 10rpx 0;
	}
	.item_range{
		display: flex;
		justify-content: flex-end;
		margin-bottom: 45rpx;
		.item_info{
			background-color: #dcdde1;
			padding: 25rpx;
			// position: absolute;
			// right: 20rpx;
			border-radius: 20rpx;
			margin-right: -30rpx;
		}
		.item_tail{
			// position: absolute;
			// right: 0;
			width: 0;
			height: 0;
			// top: 20rpx;
			border: 26rpx #dcdde1 solid;
			border-color:  transparent  transparent #dcdde1 transparent ;
		}
	}
</style>
