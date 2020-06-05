<template>
	<view class="main">
		<view class="top-img">
			<image src="../../static/icon/info/mine.jpg" mode="scaleToFill" class="img"></image>
		</view>
		<view class="mid-body">
			<view class="person">
				<template v-if="!tflog">
					<view class="title">
						<view class="login" @click="toLogin">立即登录</view>
						<view class="detail">
							<view class="detail-v">
								<view class="detail-content">
									<view>***</view>
									<view>余额</view>
								</view>
							</view>
							<view class="detail-v">
								<view class="detail-content">
									<view>***</view>
									<view>红包</view>
								</view>
							</view>
							<view class="detail-v">
								<view class="detail-content">
									<view>***</view>
									<view>卡券</view>
								</view>
							</view>
						</view>
					</view>
				</template>
				<template v-else>
					<view class="title">
						<view class="login" @click="toLogin">你好！{{username}}</view>
						<view class="detail">
							<view class="detail-v">
								<view class="detail-content">
									<view>0</view>
									<view>余额</view>
								</view>
							</view>
							<view class="detail-v">
								<view class="detail-content">
									<view>0</view>
									<view>红包</view>
								</view>
							</view>
							<view class="detail-v">
								<view class="detail-content">
									<view>0</view>
									<view>卡券</view>
								</view>
							</view>
						</view>
					</view>
				</template>
				<view class="per-icon">
					<image src="../../static/icon/info/美食.png"></image>
				</view>
			</view>
			<view class="service">
				<view class="option"@click="openpriv">
					<text class="iconfont icon-ziliao op-icon"></text>
					<view>我的资料</view>
					<text class="iconfont icon-jiantou op-tail-icon"></text>
				</view>
				
				<view class="option"@click="openaddr">
					<text class="iconfont icon-addr op-icon"></text>
					<view>我的地址</view>
					<text class="iconfont icon-jiantou op-tail-icon"></text>
				</view>
				
				<view class="option"@click="openchat">
					<text class="iconfont icon-kefu op-icon"></text>
					<view>我的客服</view>
					<text class="iconfont icon-jiantou op-tail-icon"></text>
				</view>
				
				<view class="option">
					<text class="iconfont icon-shoucang op-icon"></text>
					<view>我的收藏</view>
					<text class="iconfont icon-jiantou op-tail-icon"></text>
				</view>
				
				<view class="option">
					<text class="iconfont icon-shezhi op-icon"></text>
					<view>设置</view>
					<text class="iconfont icon-jiantou op-tail-icon"></text>
				</view>
				
				<view class="option">
					<text class="iconfont icon-more op-icon"></text>
					<view>更多选择</view>
					<text class="iconfont icon-jiantou op-tail-icon"></text>
				</view>
			</view>
		</view>	
	</view>
</template>

<script>
	import {mapState} from 'vuex'
	export default {
		data(){
			return {
			};
		},
		computed:{
			...mapState({tflog:'islogin',username:'uussername'})
		},
		methods:{
			toLogin(){
				uni.navigateTo({
					url: 'login',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			openpriv(){
				uni.navigateTo({
					url: 'privtinfo_page',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			openaddr(){
				uni.navigateTo({
					url: 'address_page',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			openchat(){
				uni.navigateTo({
					url: 'chat_page',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			}
		}
	}
</script>

<style lang="scss">
	page{
		background-color: #f1f8fa;
	}
	.main{
		width: 100%;
		height: 100%;
	}
	.img{
		width: 100%;
		height: calc(410 / 594 * 750rpx);
	}
	.mid-body{
		padding: 0 30rpx;
		display: flex;
		flex-direction: column;
		justify-content: flex-start;
		height: 100%;
		.person{
			position: relative;
			display: flex;
			flex-direction: row;
			justify-content: space-around;
			border-radius: 8rpx;
			height: 240rpx;
			margin-top: -135rpx;
			margin-bottom: 30rpx;
			box-shadow: 0 20rpx 20rpx -20rpx rgba(51, 51, 51, 0.1);
			width: 100%;
			background-color: #FFFFFF;
			.per-icon{
				margin:20rpx;
				width: 180rpx;
				height: 180rpx;
				border-radius: 50%;
				background-color: $d-color;
				display: flex;
				align-items: center;
				justify-content: center;
				image{
					width: 100rpx;
					height: 100rpx;
					flex-shrink: 0;
				}
			}
			.title{
				display: flex;
				flex-direction: column;
				margin:20rpx;
				justify-content: space-between;
				.login{
					font-size: 50rpx;
					font-weight: bold;
					width: 350rpx;
					height: 100rpx;
				}
				.detail{
					display: flex;
					flex-direction: row;
					justify-content: space-around;
					.detail-v{
						width: 100rpx;
						margin-bottom: 20rpx;
						.detail-content{
							font-weight: 500;
							color: #5a5b5c;
							display: flex;
							flex-direction: column;
							align-items: center;
						}
					}
				}
			}

		}
		.service{
			position: relative;
			display: flex;
			flex-direction: column;
			border-radius: 8rpx;
			margin-bottom: 30rpx;
			box-shadow: 0 20rpx 20rpx -20rpx rgba(51, 51, 51, 0.1);
			width: 100%;
			background-color: #FFFFFF;
			.a-line{
				width: 100%;
				height: 2rpx;
				background-color: #C0C0C0;
			}
			.option{
				display: flex;
				flex-direction: row;
				align-items: center;
				position: relative;
				margin: 30rpx;
				.op-icon{
					font-size: 40rpx;
					margin-right: 20rpx;
				}
				.op-tail-icon{
					position: absolute;
					font-size: 40rpx;
					right: 10rpx;
				}
			}
		}
	}
</style>
