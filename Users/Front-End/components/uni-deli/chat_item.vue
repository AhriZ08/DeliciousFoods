<template>
	<view>
		<view class="ttt">
			<view class="item_range">
				<view class="item_info">{{value}}</view>
				<view class="item_tail"></view>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		props:{
			value:{
				type:String
			}
		},
		data() {
			return {
				
			};
		},
		methods:{
			

		},
		mounted:function() {
		}
		
}
</script>

<style lang="scss">
	.item_range{
		// position: relative;
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
