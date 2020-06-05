<template>
	<view>
		<view>
			<!-- 轮播图 -->
			<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" class="swiper">
				<swiper-item v-for="(item,index) in ad":key = index>
					<image :src="item" ></image>
				</swiper-item>
			</swiper>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				ad:[
					"http://ffive.com.cn/uploadfiles/image/201905/33.jpg",
					"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590956146842&di=778481e6430cd9b1e99678baa9ccdab7&imgtype=0&src=http%3A%2F%2Fp0.meituan.net%2Fwaimaipoi%2Fbff12049e7a8cda15dcbf8389865e42b29711.jpg%2540700w_700h_1e_1c_1l%257Cwatermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20",
					"http://data.5ikfc.com/static/discount/kfc/18/kfc-5ikfc-1126_192.jpg"
					
				]
			};
		}
	}
</script>

<style lang="scss" scoped>
	.swiper{
		width: 730rpx;
		height: 300rpx;
		padding-right: 10rpx;
		padding-top: 20rpx;
		image{
			height: 100%;
			width: 100%;
		}
	}
</style>
