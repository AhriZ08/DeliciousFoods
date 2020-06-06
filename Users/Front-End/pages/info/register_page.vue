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
					<!-- <image src="../../static/icon/index/main/我的.png"></image> -->
					<input type="text" placeholder="请输入手机号" :value="S_num" @input="changeNum"/>
				</view>
			</view>

			<view class="Regis_t" style="display: flex; align-items: center;">
				<view class="mid-input" style="width: 330rpx; margin-left: 5rpx;">
					<!-- <image src="../../static/icon/info/昵称.png" style="width: 53rpx; height: 53rpx;"></image> -->
					<input type="text" placeholder="请输入验证码"/>
				</view>
				<view style="margin-top: -20rpx; margin-left: 10rpx; ">
					<button size="mini" style="width: 200rpx;border-radius: 12rpx; height: 90rpx; font-size: 26rpx; display:flex; align-items: center; background-color: #ffcf9b;" @click="checkNum">发送验证码</button>
				</view>
			</view>
			<view class="Regis_t">
				<view class="mid-input">
					<!-- <image src="../../static/icon/info/密码.png" ></image> -->
					<input type="text" placeholder="密码" password="ture"/>
				</view>
			</view>
			<view class="Regis_t">
				<view class="mid-input">
					<!-- <image src="../../static/icon/info/密码.png" ></image> -->
					<input type="text" placeholder="请再次输入密码" password="ture"/>
				</view>
			</view>
<!-- 			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/安全.png"></image>
					<view class="picker" style="margin-left: 10rpx;">
						<picker @change="bindPickerChange" :value="index" :range="array">
							<view class="uni-input">{{array[index]}}</view>
						</picker>
					</view>
				</view>
			</view> -->
<!-- 			<view class="Regis_t">
				<view class="mid-input">
					<image src="../../static/icon/info/抢答答案.png" ></image>
					<input type="text" placeholder="密保答案"/>
				</view>
			</view> -->
			<view class="Regis_t">
				<view class="mid-input">
					<!-- <image src="../../static/icon/info/地址.png" ></image> -->
					<view style="width: 500rpx;margin-left: 40rpx;">
						<input type="text" placeholder="送达地址" style="width: 100%;"/>
					</view>
				</view>
			</view>
			<view class="butt_regis">
				<button size="default">点击注册</button>
			</view>
			<uni-popup ref="popupMess" type="center">
				 <view class="popMess">
				 	手机号输入错误！
				 </view>
			</uni-popup>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				index:0,
				S_num:""
			};
		},
		methods:{
			bindPickerChange(e){
				this.index = e.target.value
			},
			changeNum(e){
				this.S_num = e.target.value
			},
			checkNum(){
				if (!/^1[34578]\d{9}$/.test(this.S_num)){
					this.$refs.popupMess.open();
				}
				else{
					console.log("手机号输入成功");
				}
			}
		}
	}
</script>

<style lang="scss" scoped>
	.popMess{
		display: flex;
		align-items: center;
		justify-content: center;
		border-radius: 30rpx;
		width: 300rpx;
		height: 150rpx;
		background-color: #FFFFFF;
	}
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
			border-radius: 20rpx;
			box-shadow: 0 0 60upx 0 rgba(43,86,112,.1) ;
			height: 25rpx;
			width: 550rpx;
			image{
				width: 50rpx;
				height: 50rpx;
			}
			input{
				color: #535c68;
				width: 250rpx;
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
			// color: #FFFFFF;
			background:linear-gradient(to right, rgba(255, 190, 118, 1.0), rgba(255, 204, 37, 1.0));
		}
	}
</style>
