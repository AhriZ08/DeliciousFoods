<template>
	<view >
		<view class="home">
			<!-- 搜索栏 -->
			<view class="search-cont">
				<!-- 搜索框里面的内容 -->
				<view class="search">
					<view class="search-img">
						<image src="@/static/icon/index/main/搜索.png" ></image>
					</view>
					<input type="text" :value="Svalue" @focus="tclean" @confirm="firm" @input="getload" class="Sinput"/>
				</view>
				<!-- 搜索按钮 -->
				<button class="search-button" size="mini" @click="firm">搜索</button>
			</view>
			<!-- 搜索内容 -->
			<view class="home-list">
				<!-- 当未进行搜索时 ，显示搜索历史-->
				<view class="list" v-if="itemlist.length==0">
					<view class="list-info">
						<view class="list-text">浏览历史</view>
						<view class="list-clean"@click="cleancont">清空</view>
					</view>
					<!-- 对搜索历史的内容进行判断 -->
					<view class="list-content">
						<view v-if="historyList.length>0" class="list-item" v-for="(item,index) in historyList":key=index >{{item.name}}</view>
						<view v-if="historyList.length==0" class="no-content">没有搜索历史</view>
					</view>
				</view>
				<!-- 已进行搜索时 -->
				<view v-else>
					<shopt v-for="(item,index) in itemlist":key =index :shoptl=item class="shop-tt" ></shopt>
				</view>
				
			</view>
		</view>
		
	</view>
</template>

<script>
	import shopt from '../uni-deli/shop-t.vue'
	import {mapState} from 'vuex'
	export default {
		data() {
			return {
				Svalue:"茶百道",
				itemlist:[]
			};
		},
		components:{
			shopt
		},
		computed:{
			...mapState(['historyList'])
		},
		methods:{
			tclean(){
				return this.Svalue="";
			},
			firm(){
				console.log(this.Svalue);
				this.$store.dispatch('set_history',{
					name:this.Svalue
				})
				var _this = this
				uni.request({
					url: 'http://47.112.243.221:8080/dFoods/sp/search?keyWords='+_this.Svalue,
					method: 'GET',
					data: {},
					success: res => {
						console.log(res);
						_this.itemlist = res.data
						console.log(_this.itemlist);
						},
					fail: (e) => {console.log(e);},
					complete: () => {}
				});
			},
			cleancont(){
				this.$store.dispatch('clean_history')
				
			},
			getload(e){
				this.Svalue = e.detail.value
			}
			
		}
		
	}
</script>

<style scoped lang="scss">
	.home-list{
		padding: 0 10rpx;
		margin-top: 100rpx;
		// background-color: #f1f2f6;
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
		align-items: center;
		top: 0;
		.search{
				height: 85rpx;
				width: 580rpx;
				height: 80%;
				display: flex;
				background-color: #FFFFFF;
				border-radius: 15rpx;
				align-items: center;
				margin-left: 20rpx;
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
		.search-button{
			display: flex;
			font-size: 29rpx;
		}
	}
	.shop-tt{
		margin:10rpx auto;
	}
</style>
