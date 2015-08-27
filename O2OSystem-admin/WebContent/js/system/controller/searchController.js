Ext.define('config.controller.searchController', {
	extend : 'Ext.app.Controller',
	basicConfigDTO:{},

	init : function(application) {
		this.control({
			'#searchView':{
				afterrender:this.loadData
			},
			'#categoryList' : {
				selectionchange : this.checkButtonAccess
			},
			'#saveConfigBtn':{
				click:this.saveConfig
			},
			'#addBtn':{
				click:this.addCategory
			},
			'#deleteBtn':{
				click:this.deleteCategory
			},
			"#searchView textfield":{
				blur: this.toTrimValue
			},
		});
	},
	toTrimValue:function(comp){
		if(Ext.typeOf(comp.getValue())=='string'){
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	loadData:function(){
		this.basicConfigDTO={
			serviceHotLine:'4008208820',
			orderAutoConfirm:14,
			orderAutoCancel:12
		};
		
		Ext.getCmp('serviceHotLine').setValue(this.basicConfigDTO.serviceHotLine);
		Ext.getCmp('orderAutoConfirmFiled').setValue(this.basicConfigDTO.orderAutoConfirm);
		Ext.getCmp('orderAutoCancelFiled').setValue(this.basicConfigDTO.orderAutoCancel);
	},
	checkButtonAccess:function(){
		var grid = Ext.getCmp('categoryList');
		var selectedRows = grid.getSelectionModel().getSelection();
		if(selectedRows.length==1 && Ext.isEmpty(selectedRows[0].data.configId)){
			Ext.getCmp('deleteBtn').setDisabled(false);
		}else{
			Ext.getCmp('deleteBtn').setDisabled(true);
		}
	},
	saveConfig:function(){
		var serviceHotLine=Ext.getCmp('serviceHotLine').getValue();
		var orderAutoConfirm=Ext.getCmp('orderAutoConfirmFiled').getValue();
		var orderAutoCancel=Ext.getCmp('orderAutoCancelFiled').getValue();
		var store=Ext.getCmp('categoryList').getStore();
		var categoryData=[];
		if(!Ext.isEmpty(serviceHotLine) && !Ext.isEmpty(orderAutoConfirm) && !Ext.isEmpty(orderAutoCancel)){
			Ext.MessageBox.alert('test', serviceHotLine+":"+orderAutoConfirm+":"+orderAutoCancel+":");
			store.each(function(){
				categoryData.push(this.data);
			});
			console.log(categoryData);
		}
	},
	addCategory:function(){
		var grid = Ext.getCmp('categoryList');
		var selectedRows = grid.getSelectionModel().getSelection();
		var store=grid.getStore();
		
		store.insert(store.data.length,new config.model.configModel());
	},
	deleteCategory:function(){
		var grid = Ext.getCmp('categoryList');
		var selectedRows = grid.getSelectionModel().getSelection();
		var store=grid.getStore();
            
		if(selectedRows.length==1){
			Ext.MessageBox.confirm('Confirm', 'Are you sure?',function(btn, text){
				if (btn == 'yes'){
					if(Ext.isEmpty(selectedRows[0].data.configId)){
						store.remove(selectedRows[0]);	
					}
				}
			});
		}
	}
});