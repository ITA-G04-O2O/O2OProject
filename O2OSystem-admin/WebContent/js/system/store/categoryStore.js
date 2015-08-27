Ext.define('config.store.categoryStore', {
    extend: 'Ext.data.Store',

    model: 'config.model.configModel',
	storeId: 'categoryStore',
	autoLoad:true,
	data:{'items':[
		{configId:'1',configName:'category',configValue:'category 1'},
		{configId:'2',configName:'category',configValue:'category 2'},
		{configId:'3',configName:'category',configValue:'category 3'},
		{configId:'4',configName:'category',configValue:'category 4'}
	]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});