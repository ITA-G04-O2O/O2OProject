/**
 * Created by HUANGVI2 on 8/26/2015.
 */
Ext.define('systemView', {
    extend: 'Ext.container.Viewport',

    itemId: 'systemView',
    layout: 'border',

    initComponent: function () {
        var _this = this;

        Ext.applyIf(_this, {
            items: [
                {
                    xtype: 'panel',
                    region: 'north',
                    height: 105,
                    layout: 'column',
                    bodyCls: 'margeBox',
                    header: false,
                    items: [
                        {
                            xtype: 'image',
                            height: 75,
                            width: 75,
                            id: 'logoImg',
                            itemId: 'logoImg'
                        },
                        {
                            xtype: 'container',
                            items: [
                                {
                                    xtype: 'label',
                                    cls: 'title',
                                    height: 75,
                                    id: 'titleLabel',
                                    itemId: 'titleLabel'
                                }
                            ]
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            items: [
                                {
                                    xtype: 'button',
                                    text: 'User',
                                    id: 'userBtn',
                                    itemId: 'userBtn'
                                },
                                {
                                    xtype: 'button',
                                    text: 'Shop',
                                    id: 'shopBtn',
                                    itemId: 'shopBtn'
                                },
                                {
                                    xtype: 'button',
                                    text: 'System',
                                    id: 'systemBtn',
                                    itemId: 'systemBtn'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    flex: 1,
                    region: 'center',
                    itemId: 'contentPanel',
                    layout: 'border',
                    bodyBorder: true,
                    bodyCls: 'paddingBox',
                    items: [
                        {
                            xtype: 'panel',
                            region: 'center',
                            itemId: 'contentPanel',
                            bodyPadding: 10,
                            title: 'System Config',
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Service hot line',
                                    allowBlank: false,
                                    id: 'serviceHotLine',
                                    itemId: 'serviceHotLineFiled'
                                },
                                {
                                    xtype: 'numberfield',
                                    fieldLabel: 'Order Auto Confirm Time',
                                    regex: /^[A-Za-z0-9]+$/,
                                    allowBlank: false,
                                    enforceMaxLength: true,
                                    maxLength: 2,
                                    maxValue: 24,
                                    minValue: 0,
                                    value: 0,
                                    id: 'orderAutoConfirmFiled',
                                    itemId: 'orderAutoConfirmFiled'
                                },
                                {
                                    xtype: 'numberfield',
                                    fieldLabel: 'Order Auto Cancel Time',
                                    allowBlank: false,
                                    regex: /^[A-Za-z0-9]+$/,
                                    enforceMaxLength: true,
                                    maxLength: 2,
                                    maxValue: 24,
                                    minValue: 0,
                                    value: 0,
                                    id: 'orderAutoCancelFiled',
                                    itemId: 'orderAutoCancelFiled'
                                },
                                {
                                    xtype: 'gridpanel',
                                    enableColumnHide: false,
                                    sortableColumns: false,
                                    store: 'categoryStore',
                                    id: 'categoryList',
                                    itemId: 'categoryList',
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'configValue',
                                            minWidth: 250,
                                            text: 'Category Name',
                                            renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                                                return record.data.configValue;
                                            },
                                            editor: {
                                                xtype: 'textfield'
                                            }
                                        }
                                    ],
                                    selModel: Ext.create('Ext.selection.CheckboxModel', {
                                        mode: 'SINGLE'
                                    }),
                                    dockedItems: [
                                        {
                                            xtype: 'toolbar',
                                            dock: 'top',
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    text: 'Add',
                                                    itemId: 'addBtn',
                                                    cls: 'highlightBtn'
                                                }, {
                                                    xtype: 'button',
                                                    text: 'Delete',
                                                    disabled: true,
                                                    id: 'deleteBtn',
                                                    itemId: 'deleteBtn',
                                                    cls: 'highlightBtn'
                                                }
                                            ]
                                        }
                                    ],
                                    plugins: [
                                        Ext.create('Ext.grid.plugin.CellEditing', {
                                            clicksToEdit: 1
                                        })
                                    ]
                                }
                            ],
                            dockedItems: [
                                {
                                    xtype: 'toolbar',
                                    dock: 'top',
                                    items: [
                                        {
                                            xtype: 'button',
                                            text: 'Save Config',
                                            itemId: 'saveConfigBtn',
                                            cls: 'highlightBtn'
                                        }
                                    ]
                                }
                            ]
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'container',
                            dock: 'top',
                            cls: 'paddingBox',
                            items: [
                                {
                                    xtype: 'label',
                                    cls: 'title',
                                    text: 'System Config'
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        _this.callParent(arguments);
    }

});