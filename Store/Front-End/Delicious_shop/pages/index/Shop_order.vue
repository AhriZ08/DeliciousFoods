<template>
	<view class="content">
		<!-- 导航条-->
		<view class="navbar">
			<view 
				v-for="(item, index) in navList" :key="index" 
				class="nav-item" 
				:class="{current: tabCurrentIndex === index}"
				@click="tabClick(index)">
				
				{{item.text}}
			</view>
		</view>
		<!-- 页面-->
		<swiper :current="tabCurrentIndex" class="swiper-box" duration="300" @change="changeTab">
			<swiper-item class="swiper-item" v-for="(tabItem,tabIndex) in navList" :key="tabIndex">
				<scroll-view style="height: 100%;" scroll-y="true">
					<view class="swiper-item">
						<order :orders="orders"></order>
					</view>
				</scroll-view>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	import order from"../../components/order.vue"
	export default {
		data() {
			return {
				tabCurrentIndex: 0,
				navList: [
					{
						state: 0,
						text: '全部订单',
						loadingType: 'more',
						orderList: []
					},
					{
						state: 1,
						text: '新订单',
						loadingType: 'more',
						orderList: []
					},
					{
						state: 2,
						text: '配送中',
						loadingType: 'more',
						orderList: []
					},
					{
						state: 3,
						text: '已完成',
						loadingType: 'more',
						orderList: []
					},
				],
				orders:[
					{
						status:"已完成",
						content:"多辣",
						address:"翻斗大街翻斗花园二号楼1001室",
						order_time:"16:05",
						name:"胡英俊",
						dishes:[
							"快乐炸鸡",
							"肥宅快乐水"
						],
						dish_number:2,				
					},
					{
						status:"已完成",
						content:"多辣",
						address:"翻斗大街翻斗花园二号楼1001室",
						order_time:"16:05",
						name:"胡英俊",
						dishes:[
							"快乐炸鸡",
							"肥宅快乐水"
						],
						dish_number:2,				
					},
					{
						status:"已完成",
						content:"多辣",
						address:"翻斗大街翻斗花园二号楼1001室",
						order_time:"16:05",
						name:"胡英俊",
						dishes:[
							"快乐炸鸡",
							"肥宅快乐水"
						],
						dish_number:2,				
					},
				],
																
			}
		},
	
		
		methods: {
			//swiper切换
			changeTab(e){
				this.tabCurrentIndex = e.target.current;
				this.loadData('tabChange');
			},
			
			
			tabClick(index){
				this.tabCurrentIndex = index;
			},
			
		},
		components:{
			"order":order,	
		}
	
	}
</script>

<style>
	.content{
		background-color: #EEEEEE;
		display: flex;
		flex-direction:column;
	}
	// 导航
	.navbar{
		display: flex;
		height: 40px;
		padding: 0 5px;
		background: #fff;
		box-shadow: 0 1px 5px rgba(0,0,0,.06);
		position: relative;
		z-index: 10;
		}
	.nav-item{
		
		flex: 1;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
		font-size: 15px;
		color:#3F536E;
		position: relative;	
	
	}
	.current{
		color:#EB511B;
	}
	.current after{
			content: '';
			position: absolute;
			left: 50%;
			bottom: 0;
			transform: translateX(-50%);
			width: 44px;
			height: 0;
			border-bottom: 2px solid #EB511B;
		}
	

	//订单
	.swiper-box{
		flex: 1;
	}
	.swiper-item{
		
	}
	
</style>
	