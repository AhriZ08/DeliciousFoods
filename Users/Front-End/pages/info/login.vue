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
					<input type="text" placeholder="请输入密码" :password="showpassword" @blur="showPwd"/>
					<text class="iconfont pwd-view" @tap="showPwd" :class="showpassword==true?'icon-view-off':'icon-view'"></text>
				</view>
				<view class="mid-btn">
					<button form-type="submit" @click="loginStart">登录</button>
				</view>
				<view class="register">
					<view @click="openreg">还没有账号？点击注册</view>
				</view>
				
			</form>
		</view>
	</view>
</template>

<script>
	export default{
		
		data(){
			return{
				showpassword : true,
				Sname:""
			}
		},
		methods:{
			showPwd(){
				this.showpassword = !this.showpassword
			},
			loginStart(){
				this.$store.dispatch('set_uuname',{
					name:this.Sname
				})
				this.$store.dispatch('set_login')
				uni.switchTab({
					url:'personal'
				})
			},
			openreg(){
				uni.navigateTo({
					url: 'register_page',
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
		justify-content: center;
		align-items: center;
		color: #1e90ff;
		font-size: 35rpx;
	}
</style>
