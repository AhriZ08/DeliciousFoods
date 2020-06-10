<template>
	<view class="container">
		<view v-if="userAddr.length!=0">
			<view :class="currentYes == index?'detatilBody-f choose':'detatilBody-f'" v-for="(item, index) in userAddr" 
			:key="index">
				<view class="location" @click="selectAddr(index, item.addr_ID)">{{item.addr}}</view>
				<view class="LocaInfo">
					<text class="name">{{item.callName}}</text>
					<text class="tel">{{item.recTel}}</text>
				</view>
				<view v-show="currentYes == index" class="iconfont icon-yes checkYes"></view>
				<view class="iconfont icon-modefy modefy" @click="toModeAddr(0, item.addr_ID)"></view>
			</view>
		</view>
		<view class="addAddr" @click="toAddAddr(1)">
			<view class="iconfont icon-addAddr addrIcon"></view>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				userID:'',
				userAddr:[],
				currentYes:0,
				slctAddrID:0
			}
		},
		onLoad(opt) {
			this.userID = opt.userID;
			this.slctAddrID = opt.slctAddrID;
		},
		onUnload() {
			this.userAddr.forEach(item=>{
				if (item.addr_ID == this.slctAddrID){
					uni.setStorageSync('selectedAddr', item);
				}
			})
		},
		methods:{
			selectAddr(i, id){
				this.currentYes = i;
				this.slctAddrID = id;
			},
			toModeAddr(ops, addrid){
				uni.showLoading({title: '加载中'});
				this.userAddr.forEach(item=>{
					if (item.addr_ID == addrid){
						uni.setStorageSync('selectedAddr', item);
					}
				})
				uni.navigateTo({
					url: '/pages/addr/updateAddr?ops='+ops
				});
				uni.hideLoading();
			},
			toAddAddr(ops){
				uni.showLoading({title: '加载中'});
				uni.navigateTo({
					url: '/pages/addr/updateAddr?ops='+ops
				});
				uni.hideLoading();
			},
			async initAddr(){
				var that = this;
				await uni.request({
					url:"http://47.112.243.221:8080/dFoods/user/addr/"+that.userID,
					method:"GET",
					success:(res)=>{
						if (res.data.status){
							that.userAddr = res.data.object.addrList;
							that.userAddr.forEach((item,i)=>{
								if (item.addr_ID == that.slctAddrID){
									that.currentYes = i;
								}
							})
						}else{
							uni.showToast({
								title:'加载地址失败！',
								icon:'none',
								position:'center'
							})
							console.log(res.data);
						};
						uni.hideLoading();
					},fail: () => {
						uni.hideLoading();
						uni.showToast({
							title:'加载地址失败！',
							icon:'none',
							position:'center'
						})
						
					}
				})
			}
		},
		async onShow(){
			uni.showLoading({
				title:'加载中'
			});
			await this.initAddr();
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
		.location{
			font-size: 35rpx;
			font-weight: 550;
			margin: 20rpx 20rpx 10rpx 80rpx;
		}
		.LocaInfo{
			margin: 0 0 30rpx 80rpx;
			color: #777777;
			font-size: 26rpx;
			width: 300rpx;
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			align-items: center;
		}
	}
	.behindSpline{
		width: 650rpx;
		height: 2rpx;
		background-color: #f2f2f2;
		margin: 10rpx auto 20rpx auto;
	}
	.checkYes{
		position: absolute;
		left: 20rpx;
		bottom: 50rpx;
		font-size: 38rpx;
		color: #f07373;
		font-weight: bold;
	}
	.modefy{
		position: absolute;
		right: 20rpx;
		bottom: 20rpx;
		font-size: 45rpx;
		width: 60rpx;
		height: 60rpx;
		color: #777777;
	}
	.addAddr{
		width: 700rpx;
		height: 130rpx;
		border-radius: 20rpx;
		box-shadow: 0 0 6rpx 2rpx rgba(51, 51, 51, 0.1);
		margin: 30rpx auto 20rpx auto;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		.addrIcon{
			font-size: 50rpx;
			color: #777777;
		}
	}
	.choose{
		color: #f07373;
	}
</style>
