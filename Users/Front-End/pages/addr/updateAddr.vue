<template>
	<view class="container">
		<view class="detatilBody-f" v-if="ops==0">
			<view class="bodyTitle"><view class="tag"></view>修改地址</view>
			<view class="behindSpline"></view>
			<view class="inputInfo">
				<text>联系人</text>
				<input type="text" value="啦啦啦啦" placeholder="请填写联系人"/>
			</view>
			<view class="inputInfo">
				<text>地址</text>
				<input type="text" value="爱神的箭卡萨丁就看" placeholder="请填写地址"/>
			</view>
			<view class="inputInfo lastInput">
				<text>联系电话</text>
				<input type="text" value="21654654" placeholder="请填写联系电话"/>
			</view>
		</view>
		<view class="detatilBody-f" v-if="ops==1">
			<view class="bodyTitle"><view class="tag"></view>新增地址</view>
			<view class="behindSpline"></view>
			<view class="inputInfo">
				<text>联系人</text>
				<input type="text" value="" placeholder="请填写联系人"/>
			</view>
			<view class="inputInfo">
				<text>地址</text>
				<input type="text" value="" placeholder="请填写地址"/>
			</view>
			<view class="inputInfo lastInput">
				<text>联系电话</text>
				<input type="text" value="" placeholder="请填写联系电话"/>
			</view>
	
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				ops:0
			}
		},
		onLoad(data) {
			//console.log(data);
			this.ops=data.ops
		}
	}
</script>

<style lang="scss">
	page{
		background-color: #f2f2f2;
	}
	.container{
		overflow: hidden;
		position: relative;
	}
	.detatilBody-f{
		width: 700rpx;
		border-radius: 20rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		position: relative;
		.bodyTitle{
			font-size: 35rpx;
			font-weight: 500;
			font-family: Arial, Helvetica, sans-serif;
			margin: 20rpx 0rpx 10rpx 30rpx;
			letter-spacing: 3rpx;
			display: flex;
			flex-direction: row;
			justify-content: flex-start;
			align-items: center;
			.tag{
				width: 10rpx;
				height: 42rpx;
				background-color: #f07373;
				border-radius: 30rpx;
				margin-right: 16rpx;
			}
		}
	}
	.behindSpline{
		width: 650rpx;
		height: 2rpx;
		background-color: rgba(192, 192,192, 0.3);
		margin: 10rpx auto 20rpx auto;
	}
	.inputInfo{
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: flex-start;
		margin: 0 0 25rpx 25rpx;
		text{
			text-align: justify;
			text-align-last: justify;
			width: 130rpx;
		}
		input{
			margin-top: 10rpx;
			margin-left: 20rpx;
			border-bottom: 1rpx solid #999999;
			font-size: 30rpx;
			width: 450rpx;
			padding: 10rpx;
			color: #999999;
		}
	}
	.lastInput{
		margin-bottom: 35rpx;
	}
</style>
