// Vuex状态管理
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	// 数据源
	state:{
		historyList:[],
		islogin:false,
		uussername:"name"
	},
	mutations:{
		SET_HISTORY_LIST(state,history){
			state.historyList = history
		},
		SET_IS_LOGIN(state){
			state.islogin = !state.islogin
		},
		SET_USER_NAME(state,tname){
			state.uussername = tname.name
			console.log(state.uussername);
		}
	},
	actions:{
		set_history({commit,state},history){
			let list = state.historyList
			list.unshift(history)
			commit('SET_HISTORY_LIST',list)
		},
		clean_history({commit,state}){
			let list = []
			commit('SET_HISTORY_LIST',list)
		},
		set_login({commit,state}){
			commit('SET_IS_LOGIN')
		},
		set_uuname({commit,state},lname){
			commit('SET_USER_NAME',lname)
		}
	}
})

export default store