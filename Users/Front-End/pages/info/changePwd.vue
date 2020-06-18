<template>
	<view class="container">
		<view class="mainBody">
			<view class="oneInput">
				<input placeholder="请输入手机号" v-model="modifyInfo.tel"/>
			</view>
			<view class="haveTwo">
				<input placeholder="请输入验证码" v-model="modifyInfo.testifyNum"/>
				<button @click="checkNum">获取验证码</button>
			</view>
			<view class="oneInput">
				<input placeholder="请输入新密码" v-model="modifyInfo.pwd" password="true"/>
			</view>
			<view class="oneInput">
				<input placeholder="确认新密码" v-model="cfPwd" password="true"/>
			</view>
			<button class="submitBtn" @click="modifyTel">修改密码</button>
		</view>
		<uni-popup ref="popupMess" type="center">
			 <view class="popMess">
			 	手机号输入错误！
			 </view>
		</uni-popup>
		<uni-popup ref="popupMass" type="center">
			 <view class="popMess">
			 	验证码输入错误！
			 </view>
		</uni-popup>
		<uni-popup ref="popupPwdMass" type="center">
			 <view class="popMess">
			 	两次密码不一致！
			 </view>
		</uni-popup>
	</view>
</template>

<script>
	import uniPopup from '@/components/uni-popup/uni-popup.vue'
	import uniPopupMessage from '@/components/uni-popup/uni-popup-message.vue'
	import uniPopupDialog from '@/components/uni-popup/uni-popup-dialog.vue'
	export default{
		data(){
			return{
				S_getn:'1',
				modifyInfo:{
					tel:'',
					testifyNum:'',
					pwd:''
				},
				cfPwd:''
			}
		},
		components: {
			uniPopup,
			uniPopupMessage,
			uniPopupDialog
		},
		methods:{
			checkNum(){
				if (!/^1[34578]\d{9}$/.test(this.modifyInfo.tel)){
					this.$refs.popupMess.open();
				}
				else{
					console.log("手机号输入成功");
					var _this = this
					uni.request({
						url: 'http://47.112.243.221:8080/dFoods/sms',
						method: 'GET',
						data: {
							tel_num:_this.modifyInfo.tel
						},
						success: res => {
							_this.S_getn = res.data
							},
						fail: (e) => {console.log(e);},
						complete: () => {}
					});
				}
			},
			modifyTel(){
				if (this.S_getn != this.modifyInfo.testifyNum){
					this.$refs.popupMass.open();
				}else if(this.cfPwd != this.modifyInfo.pwd){
					this.$refs.popupPwdMass.open();
				}else{
					var that = this
					uni.request({
						url: 'http://47.112.243.221:8080/dFoods/user/modpwd',
						data:{
							tel:that.modifyInfo.tel,
							pwd:that.modifyInfo.pwd
						},
						method: 'GET',
						success: res => {
							if (res.data == "success"){
								uni.showToast({
									title:'请重新登录',
									position:'center'
								});
								setTimeout(()=>{
									uni.setStorageSync('userID','');
									uni.navigateTo({
										url:'/pages/info/login'
									})
								}, 1500);
							}else {
								uni.showToast({
									title:'修改失败！',
									icon:'none',
									position:'center'
								});
							}
						},fail: (e) => {
							uni.showToast({
								title:'修改失败！',
								icon:'none',
								position:'center'
							});
							console.log(e);
						},
					});
				}
			}
		}
	}
</script>

<style lang="scss">
	page{
		background-color: #f2f2f2;
	}
	.popMess{
		display: flex;
		align-items: center;
		justify-content: center;
		border-radius: 30rpx;
		width: 300rpx;
		height: 150rpx;
		background-color: #FFFFFF;
	}
	.container{
		overflow: hidden;
		position: relative;
		color: #777777;
	}
	.mainBody{
		width: 600rpx;
		margin: 50rpx auto 0rpx auto;
	}
	.oneInput{
		display: flex;
		flex-direction: column;
		align-items: flex-start;
		margin-bottom: 20rpx;
		input{
			background-color: #FFFFFF;
			height: 100rpx;
			width: 560rpx;
		}
		text{
			margin-top: 10rpx;
			margin-left: 20rpx;
			font-size: 28rpx;
		}
	}
	.submitBtn{
		width: 600rpx;
		background-color: #f07373;
		color: #FFFFFF;
		border-radius: 10rpx;
		height: 80rpx;
		line-height: 80rpx;
		margin-top: 50rpx;
	}
	input{
		border-radius: 10rpx;
		padding-left: 40rpx;
	}
	.haveTwo{
		position: relative;
		margin-bottom: 20rpx;
		input{
			background-color: #FFFFFF;
			height: 100rpx;
			width: 60%;
		}
		button{
			position: absolute;
			width: 30%;
			height: 100rpx;
			line-height: 100rpx;
			background-color: #f07373;
			color: #FFFFFF;
			font-size: 25rpx;
			right: 0rpx;
			bottom: 0rpx;
		}
	}
</style>
