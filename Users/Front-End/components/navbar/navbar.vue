<template>
	<view >
		<view class="home">
			<!-- 导航栏 -->
			<view class="search-cont">
				<view class="search">
					<view class="search-img">
						<image src="@/static/icon/index/main/搜索.png" ></image>
					</view>
					<input type="text" :value="Svalue" @focus="tclean" @confirm="firm" class="Sinput"/>
				</view>
			</view>
			<!-- 搜索内容 -->
			<view class="home-list">
				<view class="list">
					<view class="list-info">
						<view class="list-text">浏览历史</view>
						<view class="list-clean"@click="cleancont">清空</view>
					</view>
					<view class="list-content">
						<view v-if="historyList.length>0" class="list-item" v-for="(item,index) in historyList":key=index >{{item.name}}</view>
						<view v-if="historyList.length==0" class="no-content">没有搜索历史</view>
					</view>
				</view>
			</view>
		</view>
		
	</view>
</template>

<script>
	import {mapState} from 'vuex'
	export default {
		data() {
			return {
				Svalue:"茶百道",
			};
		},
		computed:{
			...mapState(['historyList'])
		},
		methods:{
			tclean(){
				return this.Svalue="";
			},
			firm(e){
				console.log(e);
				this.$store.dispatch('set_history',{
					name:e.detail.value
				})
			},
			cleancont(){
				this.$store.dispatch('clean_history')
				
			}
		}
		
	}
</script>

<style scoped lang="scss">
	.home-list{
		margin-top: 80rpx;
		height: 9000rpx;
		background-color: #f1f2f6;
		.list{
			background-color: #FFFFFF;
			width: 100%;
			height: 250rpx;
			.list-info{
				display: flex;
				justify-content: space-between;
				border-bottom: 1px #F5F5F5 solid;
				.list-text{
					color: $d-color;
					padding: 15rpx 15rpx;
					font-weight: bold;
				}
				.list-clean{
					color: #05c46b;
					padding: 15rpx 15rpx;
					font-weight: bold;
				}
			}
			.list-content{
				padding: 15rpx;
				display: flex;
				flex-wrap: wrap;
				.list-item{
					margin-right: 30rpx;
					padding: 2rpx 10rpx;
					border: 1px #666 solid;
					border-radius: 10rpx;
				}
				.no-content{
					color: #666666;
					width: 100%;
					height: 200rpx;
					line-height: 100rpx;
					text-align: center;
					font-size: 35rpx;
				}
			}
		}
	}
	.search-cont{
		background-color:$d-color ;
		width: 100%;
		height: 80rpx;
		display: flex;
		position: fixed;
		justify-content: center;
		align-items: center;
		top: 0;
		.search{
				height: 85rpx;
				width: 90%;
				height: 80%;
				display: flex;
				background-color: #EEEEEE;
				border-radius: 15rpx;
				align-items: center;
				.search-img{
					width: 50rpx;
					height: 50rpx;
					margin-left: 10rpx;
					margin-right: 10rpx;
					image{
						width: 100%;
						height: 100%;
					}
				}
				.Sinput{font-size: 35rpx;}
		
		}
	}
</style>
