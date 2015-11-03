function mod_classify(){
	$('#mod_classify_win').window('open');
	var node = $('#type_tree').tree('getSelected');
	name=node.text;
	$("#mod_classify_name_ipt").textbox('setValue',name);
}
function sub_mod_classify(){
	var node = $('#type_tree').tree('getSelected');
	var parent = $('#type_tree').tree('getParent',node.target);
	name=$("#mod_classify_name_ipt").textbox('getValue');
	if (node) {
		$.messager.confirm('提示',
				'确认修改吗？', function(
						r) {
					if (r) {
						$.post('mod_classify_act', {
							id : node.id,
							name:name,
							parentId:parent.id
							}, function() {
						$('#type_tree').tree('reload');
					$('#mod_classify_win').window('close');
						});
					}
				});
	}
	
}


function mod_ele(){
	$('#mod_ele_win').window('open');
	var row = $('#businessElements').datagrid('getSelected');
	name = row.name;
	id = row.id;
	isRequired=row.isRequired;
	$("#ele_name").textbox('setValue',name);
	$("#ele_isRequired").prop("checked",row.isRequired);
	}

function sub_mod_ele_form(){
	var row = $('#businessElements').datagrid('getSelected');
	if (row) {
			$.messager.confirm('提示',
					'确认修改吗？', function(
							r) {
						if (r) {
							$.post('mod_ele', {
								id : row.id,
								name:$("#ele_name").val(),
								isRequired:$("#ele_isRequired").prop("checked")
							}, function() {
							$('#businessElements').datagrid('reload');
						$('#mod_ele_win').window('close');
							});
						}
					});
		}
	}


function mod_biz(){
	$('#mod_biz_win').window('open');
	var row = $('#business_datagrid').datagrid('getSelected');
	title = row.title;
	id = row.id;
	parentId=row.parentId;
	
	$("#mod_biz_title_ipt").textbox('setValue',title);
	var url = "findDetailByBid?bid="+id;
	
	$('#mod_detail_dg').datagrid({
		url : url,
		method:'post',
		onClickCell: function(index,field){
			if (isEndEdit_dg("mod_detail_dg")){
				$('#mod_detail_dg').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		},
		idField : 'id',
		singleSelect : true,
		rownumbers : true,
		columns : [ [ {
			field : 'id',
			title : 'id'
		}, {
			field : 'elementId',
			title : '要素id'
		},{
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
	$('#mod_detail_dg').datagrid('hideColumn','id');
	$('#mod_detail_dg').datagrid('hideColumn','elementId');
	
}

function sub_mod_biz(){
	var node = $('#type_tree').tree('getSelected');
	var row = $('#business_datagrid').datagrid('getSelected');
	title = row.title;
	id = row.id;
	parentId=row.parentId;
	endEdit("mod_detail_dg");
	
	$('#mod_biz_form').form('submit', {
		url : 'mod_biz_act',
		onSubmit : function(param) {
			param.parentId=parentId
			param.id=id;
			param.details=JSON.stringify($('#mod_detail_dg').datagrid('getRows'));
		},
		success : function(data) {
			$('#mod_biz_win').window('close');
			var url="queryBusiness?nodeId="+node.id;
			$('#business_datagrid').datagrid('load',url)
		}
	});
}
function mod_qst(){
	$('#mod_qst_win').window('open');
	var row = $('#question_datagrid').datagrid('getSelected');
	content = row.content;
	id = row.id;
//	isRequired=row.isRequired;
	$("#mod_qst_content_ipt").textbox('setValue',content);
//	$("#ele_isRequired").prop("checked",row.isRequired);

}


function sub_mod_qst(){
	var row = $('#question_datagrid').datagrid('getSelected');
	id = row.id;
	if (row) {
		$.messager.confirm('提示',
				'确认修改吗？', function(
						r) {
					if (r) {
						$.post('mod_qst_act', {
							id : id,
							content:$("#mod_qst_content_ipt").val()
							}, function() {
								$('#question_datagrid').datagrid('reload');
//						$('#type_tree').tree('reload');
					$('#mod_qst_win').window('close');
						});
					}
				});
	}
}