<template>
	<view class="content">
		
		<scroll-view scroll-y="true" >
			<view v-for="(item,index) in reviews" :key="index">
				<view class="review_item">
					<view class="item_information">
						<image :src="item.head"></image>
						<text>{{item.name}}</text>
						<text>{{item.time_day}}\n</text>
						<text>{{item.tims_minute}}</text>
						<text>{{item.grade}}</text>
					</view>
					<navigator url="review_item">
						<view class="item_content">
							<text>{{item.content}}</text>
						</view>
					</navigator>
				</view>
			</view>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				reviews:[
					{
						name:"胡图图",
						time_day:"2020/06/02",
						tims_minute:"20:08",
						head:"../../static/Resource_review/个人头像.jpg",
						content:"默认好评啊啊啊啊啊啊啊啊长宽比吧哭吧哭吧可算把biubiu爱步",
						grade:"★★★★★"
					},					
					{
						name:"胡图图",
						time_day:"2020/06/02",
						tims_minute:"20:08",
						head:"../../static/Resource_review/个人头像.jpg",
						content:"默认好评",
						grade:"★★★★★"
					}
				]
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.content{
		background-color: #EEEEEE;
		display: flex;
		flex-direction:column;
	}
	.review_item{
		background-color: #FFFFFF;
		display:flex;
		flex-direction: column;
		margin: 30rpx auto;
		width: 90%;
		border-style:groove;
		border: 2rpx;
		border-radius: 5rpx;
	}
	.item_information image{
		width:100rpx;
		height: 100rpx;
		border-radius: 50rpx;
	}
	.item_information{
		margin-left: 20rpx;
		margin-top: 10rpx;
	}
	.item_information text
	{
		position: absolute;
	}
	//名字
	.item_information text:nth-child(2)
	{
		margin-left: 100rpx;
		font-size: large;
		margin-top: 10rpx;
	}
	//年月日
	.item_information text:nth-child(3)
	{
		margin-left: 300rpx;
		margin-top: 13rpx;
		font-size: small;
	}
	//时间
	.item_information text:nth-child(4)
	{
		margin-left: 300rpx;
		margin-top: 70rpx;
		font-size: small;
	//评分
	}.item_information text:nth-child(5)
	{
		margin-left: 100rpx;
		margin-top: 70rpx;
		color: #DD524D;
	}
	.item_content{
		margin-left: 20rpx;
		margin-top: 20rpx;
		width: 92%;
		border-radius: 15rpx;
		border: #999999 4rpx;
		border-style: groove;
	}
	.item_content text{
		margin-left: 5rpx;
		word-break: break-all;/*属性规定自动换行的处理方法。normal(使用浏览器默认的换行规则。),break-all(允许在单词内换行。),keep-all(只能在半角空格或连字符处换行。)*/
		text-overflow: ellipsis;
		display: -webkit-box; /** 对象作为伸缩盒子模型显示 **/
		-webkit-box-orient: vertical; /** 设置或检索伸缩盒对象的子元素的排列方式 **/
		-webkit-line-clamp: 1; /** 显示的行数 **/
		overflow: hidden;  
	}
</style>
