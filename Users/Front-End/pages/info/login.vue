<template>
	<view class="main-list">
		<view class="head-icon">
			<image src="../../static/icon/info/icon-shop.png"></image>
		</view>
		<view class="mid">
			<form id="loginForm">
				<view class="mid-input">
					<text class="iconfont icon-person img"></text>
					<input type="text" placeholder="请输入账号" :value="Sname" @input="test"/>
				</view>
				<view class="mid-input">
					<text class="iconfont icon-lock img"></text>
					<input type="text" placeholder="请输入密码" :password="showpassword" @blur="showPwd" @input="changepwd"/>
					<text class="iconfont pwd-view" @tap="showPwd" :class="showpassword==true?'icon-view-off':'icon-view'"></text>
				</view>
				<view class="mid-btn">
					<button form-type="submit" @click="loginStart">登录</button>
				</view>
				<view class="register">
					<view @click="openreg">还没有账号？点击注册</view>
					<view @click="openchpwd">忘记密码？</view>
				</view>
				<uni-popup ref="popupMess" type="center">
					 <view class="popMess">
					 	账号或密码输入错误
					 </view>
				</uni-popup>
			</form>
		</view>
	</view>
</template>

<script>
	export default{
		
		data(){
			return{
				showpassword : true,
				Sname:"",
				Spwd:""
			}
		},
		methods:{
			showPwd(){
				this.showpassword = !this.showpassword
			},
			changepwd(e){
				this.Spwd = e.target.value
			},
			loginStart(){
				let a = {
					phone:this.Sname,
					pwd:this.Spwd
				}
				var _this = this
				uni.request({
					url: 'http://47.112.243.221:8080/dFoods/user/login?phone='+_this.Sname+'&pwd='+_this.Spwd,
					method: 'POST',
					data: {
					},
					success: res => {
						if(res.data.status==true){
							console.log(res.data);
							_this.$store.dispatch('set_uuname',{
								name:_this.Sname
							})
							_this.$store.dispatch('set_login')
							uni.setStorageSync('userID',res.data.msg)
							uni.switchTab({
								url:'../index/index'
							})
						}
						else{
							_this.$refs.popupMess.open();
						}
					},
					fail: (e) => {console.log(e);},
					complete: () => {}
				});

			},
			openreg(){
				uni.navigateTo({
					url: 'register_page',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			openchpwd(){
				uni.navigateTo({
					url: '/pages/info/changePwd',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			test(e){
				this.Sname = e.target.value
			}
			
		},
		computed:{
			
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
	.main-list{
		margin-top: 30rpx;
		display: flex;
		flex-direction: column;
		padding: 100rpx;
		justify-content: space-between;
	}
	.head-icon{
		margin-bottom: 80rpx;
		margin-left: auto;
		margin-right: auto;
		border-radius: 50%;
	}
	.head-icon image{
		width: 310rpx;
		height: 300rpx;
	}
	.img{
		font-size: 40rpx;
	}
	.mid-input{
		display: flex;
		flex-direction: row;
		justify-content: left;
		margin-bottom: 40rpx;
		border: none;
		border-radius: 2.5rem;
		box-shadow: 0 0 60upx 0 rgba(43,86,112,.1) ;
		height: 85rpx;
		align-items: center;
		padding-left: 25rpx;
	}
	.mid-input input{
		height: 35rpx;
		margin-left: 20rpx;
	}
	.pwd-view{
		font-size: 50rpx;
		margin-left: 40rpx;
	}
	.mid-btn{
		margin-top: 70rpx;
	}
	.mid-btn button{
		border: none;
		border-radius: 2.5rem;
		color: #FFFFFF;
		background:linear-gradient(to right, rgba(52,152,219,1.0), rgba(0,168,255,0.5));
		/* box-shadow: 0 0 60upx 0 rgba(43,86,112,0.2); */
	}
	.register{
		margin-top: 25rpx;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		color: #1e90ff;
		font-size: 35rpx;
		view{
			margin-bottom: 20rpx;
		}
	}
</style>
