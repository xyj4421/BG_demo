function add_biz() {
		$('#addBusiness_window').window('open');
	}
/**********新增业务分类************/
function addNode() {

	$('#addNode_window').window('open');
	$('#treeName').text("");
}
/**********新增业务要素************/
function append() {
	//alert("append() is called")
	$('#add_window').window('open');
	
}

/**********新增业务要素************/
function submitForm() {
	//$.messager.alert("submitForm() is called");
	$('#add_form').form('submit', {
		url : 'insertElement',
		onSubmit : function() {
			//$.messager.alert("submitForm() is called");
		},
		success : function() {
			//$.messager.alert("submitForm() is success");
			$('#add_form').form('clear');
			$('#add_window').window('close');
			//$('#type_tree').tree('reload');
			$('#businessElements').datagrid('reload');
		}
	});
	

	//$('#add_form').submit();
}
function addNodeSubmit() {
	var node = $('#type_tree').tree('getSelected');
	$('#addNode_form').form('submit', {
		url : 'addNode',

		onSubmit : function(param) {
			param.id = node.id;
			//param.p2=;
			//$.messager.alert("submitForm() is called");
		},
		success : function(data) {
			/*$.messager.alert("submitForm() is success");
			
			$('#add_window').window('close');*/
			$('#treeName').val(" ");
			$('#treeName').text(" ");
			$('#addNode_window').window('close');
			$('#type_tree').tree('reload');
		}
	});
	
}