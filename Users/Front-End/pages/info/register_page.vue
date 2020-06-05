<template>
	<view>
		<view class="ttt">
			<view class="Regis_icon">
				<image src="../../static/icon/info/icon-shop.png"></image>
			</view>
		</view>
		<view class="Regis_info">
			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/index/main/我的.png"></image>
					<input type="text" placeholder="账号"/>
				</view>
			</view>

			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/昵称.png" style="width: 53rpx; height: 53rpx;"></image>
					<input type="text" placeholder="昵称" style="margin-left: 20rpx;"/>
				</view>
			</view>
			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/密码.png" ></image>
					<input type="text" placeholder="密码"/>
				</view>
			</view>
			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/安全.png"></image>
					<view class="picker" style="margin-left: 10rpx;">
						<picker @change="bindPickerChange" :value="index" :range="array">
							<view class="uni-input">{{array[index]}}</view>
						</picker>
					</view>
				</view>
			</view>
			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/抢答答案.png" ></image>
					<input type="text" placeholder="密保答案"/>
				</view>
			</view>
			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/地址.png" ></image>
					<input type="text" placeholder="送达地址" />
				</view>
			</view>
			<view class="butt_regis">
				<button size="default">点击注册</button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				index:0,
				array:[
					"请选择密保问题",
					"你的生日是什么?",
					"你初中学校的名字是什么?",
					"你宠物的名字叫什么?",
					"你最喜欢的书叫什么?"
				]
			};
		},
		methods:{
			bindPickerChange(e){
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	.ttt{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	.Regis_icon{
		margin-top: 50rpx;
		width: 100rpx;
		height: 100rpx;
		image{
			width: 100%;
			height: 100%;
		}
	}
	.Regis_t{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	.Regis_info{
		margin-top: 80rpx;
		.mid-input{
			margin-bottom: 25rpx;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 35rpx 0;
			border: none;
			border-radius: 2.5rem;
			box-shadow: 0 0 60upx 0 rgba(43,86,112,.1) ;
			height: 25rpx;
			width: 550rpx;
			image{
				width: 50rpx;
				height: 50rpx;
			}
			input{
				color: #535c68;
				width: 205rpx;
				margin-left: 20rpx;
			}
		}
	}
	.butt_regis{
		margin-top: 50rpx;
		display: flex;
		align-items: center;
		justify-content: center;
		padding: 25rpx;
		button{
			border-radius: 2.5rem;
			width: 360rpx;
			color: #FFFFFF;
			background:linear-gradient(to right, rgba(196, 69, 105, 1.0), rgba(225, 112, 85, 1.0));
		}
	}
</style>
