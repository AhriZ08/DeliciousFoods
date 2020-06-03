<template>
	<view class="content">
		<!-- 导航条-->
		<view class="navbar">
			<view 
				v-for="(item, index) in navList" :key="index" 
				class="nav-item" 
				:class="{current: tabCurrentIndex === index}"
				@click="tabClick(index)"
			>
				{{item.text}}
			</view>
		</view>
		<!-- 页面-->
		<swiper :current="tabCurrentIndex" class="swiper-box" duration="300" @change="changeTab">
			<swiper-item class="swiper-item" v-for="(tabItem,tabIndex) in navList" :key="tabIndex">
				<scroll-view style="height: 100%;" scroll-y="true">
					<view class="swiper-item">
						<view class="order-items" v-for="(item,index) in orders" :key="index">
						<!-- 订单第一行，第几个订单，和状态 -->
						<view class="order_statue">
							<text>{{item.status}}</text>
						</view>
						<!-- 订单第二行，下订单的人和下订单的时间 -->
						<view class="order-man">
							<text style="font-size: large; font-weight: 500;">{{item.name}}</text>
							<text space="emsp"style="float: right;" >于 {{item.order_time}} 下单\n</text>
							<text>\n{{item.address}}</text>
							<text space="emsp"style="color:#FF7F00;">\n备注  </text>
							<text space="emsp">:   {{item.content}}</text>
						</view>
								
						<!-- 菜 -->
						<view class="order-shops">
							<view class="order-shops"  v-for="(dish,index) in item.dishes" :key="index">
								<text space="emsp">{{dish}}    1</text>
							</view>
							<view>
								<text space="emsp" style="padding-left: 150rpx;">共 {{item.dish_number}} 件商品</text>	
							</view>
						</view>	
						<view class="Button">
							<button>取消</button>
							<button>接受</button>
						</view>
									
					</view>
					</view>
				</scroll-view>
			</swiper-item>
		</swiper>
			<!--一个订单的样式-->
			
			
	</view>
</template>

<script>
	export default {
		data() {
			return {
				tabCurrentIndex: 0,
				navList: [{
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
					{
						state: 4,
						text: '已取消',
						loadingType: 'more',
						orderList: []
					}
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
	.order-items{
		background-color: #FFFFFF;
		display:flex;
		flex-direction: column;
		margin: 30rpx auto;
		width: 90%;
		border-style:groove;
		border: 2rpx;
		border-radius: 5rpx;
	}
	.order_statue{
		font-size: large;
		font-weight: 500;
		color: #F8F8F8;
		background-color: #515151;
	}
	.order-man{
		padding-left: 20rpx;
		padding-right: 20rpx;
		margin-top: 10rpx;
		margin-bottom: 10rpx;
	}
	.order-shops{
		padding-left: 100rpx;
		border: #999999 3rpx;
		border-style: double;
	}
	.Button{
		display: flex;
	}
	.Button button:nth-child(2){
		background-color: #0091EA;
		width: 60%;
		margin-left: 10rpx;
		color: #FFFFFF;
	}
	.Button button:nth-child(1){
		width: 30%;
		margin-left: 30rpx;
	}
</style>
	