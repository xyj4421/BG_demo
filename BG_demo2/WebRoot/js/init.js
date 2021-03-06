$(function() {

		/**********业务要素***********/
	
		$('#businessElements').datagrid({
			url : "queryAllElements?ran="+Math.random(),
			method:'post',
			idField : 'id',
			singleSelect : true,
			toolbar : '#tb',
			rownumbers : true,
			columns : [ [ {				
				field : 'id',
				title : 'id'				
			}, {
				field : 'name',
				title : '名称'
			}, {
				field : 'isRequired',
				title : '是否必填',
				formatter:function(val,row){
				if(val){
					return "是";
				}else{
				return "否";
				}
				
			}
			} ] ]
		});
		
		$('#businessElements').datagrid('hideColumn','id');
		
		/**********业务分类***********/
		$('#type_tree').tree({
			url : 'queryTree',
			animate : true,
			onContextMenu : function(e, node) {
				e.preventDefault();
				$('#type_tree').tree('select', node.target);
				$('#tree_menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			onClick: function(node){
				
				var url="queryBusiness?nodeId="+node.id;
				$('#business_datagrid').datagrid('load',url);
			}

		});

		/**********分类下业务清单***********/
		$('#business_datagrid').datagrid({
			toolbar : '#classify_biz_dg_tb',
			columns : [ [ {
				field : 'id',
				title : 'id'
			}, {
				field : 'title',
				title : '业务标题'
			}, {
				field : 'parentId',
				title : '所属分类ID'
			} ] ]

		});
		
		/**********************业务要素清单********************/
		$('#addBusiness_datagrid').datagrid({
			url : 'queryAllElements?ran='+Math.random(),
			method:'post',
			onClickCell: function(index,field){
				if (endEditing()){
					$('#addBusiness_datagrid').datagrid('selectRow', index)
							.datagrid('editCell', {index:index,field:field});
					editIndex = index;
				}
			},
			idField : 'id',
			singleSelect : true,
			fitColumns:true,
			//width:'500px',
			//height:'400px',
			//toolbar : '#tb',
			rownumbers : true,
			columns : [ [ {
				field : 'id',
				title : 'id'
			}, {
				field : 'name',
				title : '要素名称'
			}, {
				field : 'isRequired',
				title : '是否必填'
			},{
				field:'content',
				title:'要素内容',
				editor:'textarea',
				width:'200px',
				height:'100px'
			} ] ]
		});
		$('#addBusiness_datagrid').datagrid('hideColumn','id');
		

$('#option_datagrid').datagrid({
	rownumbers : true,
	idField : 'id',
	singleSelect:true,
	width:'100%',
		toolbar:'#option_tb',
		columns:[[{
			field : 'id',
			title : 'id'
		},{
			field:'optContent',
			title:'选项内容'
		},{
			field:'isBusiness',
			title:'是否跳转到具体业务',
			formatter:function(val,row){
				if(val){
					return "是";
				}else{
				return "否";
				}
			}
		},{
			field:'nextId',
			title:'跳转到导航问题或具体业务的id'
			
		}]]
		});
$('#option_datagrid').datagrid('hideColumn','id');

	/*	
$('#opt_combobox').datagrid({
		url:'questionToJson',
		valueField:'id',
		textField:'text'
		});
		*/



$('#quest_dg').datagrid({
		url:'queryQuestion',
		idField:'id',
		singleSelect : true,
		width:'300px',
		height:'300px',
		columns:[[{
			field:'content'
		}]]
		});
		
		
$('#question_datagrid').datagrid({
		url:'queryQuestion',
		singleSelect:true,
		idField:'id',
		rownumbers : true,
		columns:[[{
				field : 'id',
				title : 'id'
			}, {
			field:'content',
			title:'导航问题'
		}]],
		onClickRow:function(rowIndex, rowData){
			var qid = rowData.id;
			var url = "queryByQid?qid="+qid;
			$('#option_datagrid').datagrid('load',url);
		},
		toolbar:'#question_tb'
		});
		$('#question_datagrid').datagrid('hideColumn','id');
	});