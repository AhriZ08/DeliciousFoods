<template>
	<view class="container">
		<view class="detatilBody-f" >
			<view class="bodyTitle" v-if="ops==1"><view class="tag"></view>新增地址</view>
			<view class="bodyTitle" v-if="ops==0"><view class="tag"></view>修改地址</view>
			<view class="behindSpline"></view>
			<view class="inputInfo">
				<text>联系人</text>
				<input type="text" v-model="modifyAddr.callName" placeholder="请填写联系人"/>
			</view>
			<view class="behindSpline"></view>
			<view class="inputInfo">
				<text>地址</text>
				<input type="text" v-model="modifyAddr.addr" placeholder="请填写地址"/>
			</view>
			<view class="behindSpline"></view>
			<view class="inputInfo lastInput">
				<text>联系电话</text>
				<input type="text" v-model="modifyAddr.recTel" placeholder="请填写联系电话"/>
			</view>
			<button plain="true" v-if="ops==1" @click="newAddr">添加</button>
			<button plain="true" v-if="ops==0" @click="modify">修改</button>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				ops:0,
				modifyAddr:{
					addr:'',
					callName:'',
					recTel:'',
					addr_ID:''
				},
				userID:''
			}
		},
		onLoad(data) {	
			//console.log(data);
			this.userID = uni.getStorageSync('userID');
			this.ops=data.ops;
			if (data.ops == 0){
				this.modifyAddr = uni.getStorageSync('selectedAddr');
			}
		},
		methods:{
			newAddr(){
				if(!(/^1[3456789]\d{9}$/.test(this.modifyAddr.recTel))){
					uni.showToast({
						title:'手机号码有误，请重填!',
						icon:'none',
						position:'center'
					})
				}else{
					uni.showLoading({
						title:'添加中'
					});
					let userID = this.userID;
					let addrData = JSON.stringify(this.modifyAddr);
					uni.request({
						url:"http://47.112.243.221:8080/dFoods/user/addr/add/"+userID,
						data:addrData,
						method:'POST',
						success: (res) => {
							uni.hideLoading();
							if (res.data == "success"){
								uni.showToast({
									title:'添加成功！',
									position:'center'
								});
					
							}else{
								uni.showToast({
									title:'添加失败',
									position:'center',
									icon:'none'
								});
							}
						},
						fail: () => {
							uni.hideLoading();
							uni.showToast({
								title:'添加失败',
								position:'center',
								icon:'none'
							});
						}
					})
				}
			},
			modify(){
				if(!(/^1[3456789]\d{9}$/.test(this.modifyAddr.recTel))){
					uni.showToast({
						title:'手机号码有误，请重填!',
						icon:'none',
						position:'center'
					})
				}else {
					let userID = this.userID;
					let addrData = JSON.stringify(this.modifyAddr);
					console.log(addrData);
					uni.showLoading({
						title:'修改中'
					});
					uni.request({
						url:"http://47.112.243.221:8080/dFoods/user/addr/mod/"+userID,
						data:addrData,
						method:'POST',
						success: (res) => {
							uni.hideLoading();
							if (res.data == "success"){
								uni.showToast({
									title:'修改成功！',
									position:'center'
								})
							}else{
								uni.showToast({
									title:'修改失败！',
									position:'center',
									icon:'none'
								})
							}
						},fail: () => {
							uni.hideLoading();
							uni.showToast({
								title:'修改失败！',
								position:'center',
								icon:'none'
							});
						}
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
			color: #f07373;
			.tag{
				width: 10rpx;
				height: 42rpx;
				background-color: #f07373;
				border-radius: 30rpx;
				margin-right: 16rpx;
			}
		}
		button{
			height: 60rpx;
			width: 160rpx;
			color: #f07373;
			margin: 0rpx 0rpx 15rpx 0rpx;
			border-radius: 10rpx;
			font-size: 35rpx;
			line-height: 58rpx;
			border: none;
			position: absolute;
			top: 15rpx;
			right: 0rpx;
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
		margin: 0 0 0 30rpx;
		text{
			text-align: justify;
			text-align-last: justify;
			width: 130rpx;
		}
		input{
			margin-top: 10rpx;
			margin-left: 20rpx;
			font-size: 30rpx;
			width: 450rpx;
			padding: 10rpx;
			color: #999999;
		}
	}
	.lastInput{
		margin-bottom: 20rpx;
	}
</style>
