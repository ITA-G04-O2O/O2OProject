/**
 * Created by HUANGVI2 on 8/27/2015.
 */
Ext.require(['Ext.data.*', 'Ext.grid.*', 'Ext.selection.CellModel',
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.form.*',
    'Ext.Container.*', 'Ext.tab.Panel']);

Ext.onReady(function () {

    Ext.define('UserData', {
        extend: 'Ext.data.Model',
        fields: [
            {name: "id", type: "int"},
            {name: 'uname'}, {name: 'tel'}
        ]
    });

    var userStore = Ext.create('Ext.data.Store', {
        pageSize: 10,
        model: 'UserData',
        proxy: {
            type: 'ajax',
            url: 'AdminService/users',
            reader: {root: 'object', totalProperty: 'total'}
        },
        sorters: [{
            property: 'id',
            direction: 'asc'
        }]
    });

    var userPanel = Ext.create('Ext.form.Panel', {
        title: '??',
        width: 880,
        defaultType: 'textfield',
        frame: true,
        method: 'POST',
        collapsible: true,//???
        bodyPadding: 5,
        layout: 'column',
        margin: '0 0 10 0',
        items: [{
            fieldLabel: '??',
            labelWidth: 40,
            id: 'tel'
        }, {
            xtype: 'button',
            text: '??',
            margin: '0 0 0 5',
            handler: function () {
                var name = Ext.getCmp('tel').getValue();
                if (name != "") {
                    userStore.load({params: {name: name}});
                }
            }
        }],
        renderTo: 'users'
    });

    var userGrid = Ext.create('Ext.grid.Panel', {
        title: '????',
        width: 880,
        store: userStore,
        loadMask: true,
        selModel: new Ext.selection.CheckboxModel, //??checkbox?
        columns: [{
            header: '??', dataIndex: 'uname'
        }, {
            header: '??', dataIndex: 'tel'
        }],
        dockedItems: [
            {
                xtype: 'pagingtoolbar',
                store: userStore,
                dock: 'bottom',
                emptyMsg: '????',
                displayInfo: true,
                displayMsg: '????{0}-{1}??? / ?{2}??? ',
                beforePageText: '?',
                afterPageText: '?/?{0}?'
            }, {
                xtype: 'toolbar',
                items: [{
                    iconCls: 'icon-add',
                    text: '??',
                    scope: this, //??
                    handler: function () {
                        var tels = Ext.getCmp('tel').getValue();
                        Ext.MessageBox.confirm('Notice!', tels + 'will be reset', function (btn) {
                            if (btn == 'yes') {
                                Ext.Ajax.request({
                                    url: 'AdminService/users/' + tels,
                                    method: 'post',
                                    params: {
                                        _method: 'PUT'
                                    },
                                    success: function (response, options) {
                                        if (response.result) {
                                            Ext.MessageBox.alert('Success', 'reset Success!!!');
                                        } else {
                                            Ext.MessageBox.alert('Fail', 'reset Fail!!!');
                                        }
                                    },
                                    failure: function () {
                                        Ext.MessageBox.alert('Fail', 'reset Fail!!!');
                                    }
                                });
                            }
                        });
                    }
                }]
            }],
        renderTo: 'users',
        listeners: {
            //?????? records ??? ??
            itemclick: function (dv, records, item, index, e) {
                //alert(record.data.id);

            }, selectionchange: function (model, records) {
                if (records[0]) {
                    userPanel.show(); //??
                    userPanel.loadRecord(records[0]);
                }
            }
        }
    });
    userStore.loadPage(1);
});