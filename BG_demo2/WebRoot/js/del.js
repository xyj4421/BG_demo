/**********删除业务分类************/
	function removeTreeNode() {
		var node = $('#type_tree').tree('getSelected');
		if (node) {
			$.messager.confirm('提示',
					'确认删除吗？', function(
							r) {
						if (r) {
							//alert("aaaaaaaaaaS");
							$.post('deleteNode', {
								id : node.id
							}, function(result) {
							$('#type_tree').tree('reload');
								
							});
						}
					});
		}
	}
	function removeElement() {
		var row = $('#businessElements').datagrid('getSelected');
		if (row) {
			$.messager.confirm('提示',
					'确认删除吗？', function(
							r) {
						if (r) {
							$.post('deleteElement', {
								id : row.id
							}, function() {
							$('#businessElements').datagrid('reload');
								//alert(result.success);
								/*
								if (result.success) {

									$('#businessElements').datagrid('reload'); // reload the user data
								} else {
									$('#businessElements').datagrid('reload');
									$.messager.show({ // show error message
										title : 'Error',
										msg : "error"
									});
								}*/
							});
						}
					});
		}

	}
	function del_biz() {
		var row = $('#business_datagrid').datagrid('getSelected');
		if (row) {
			$.messager.confirm('提示',
					'确认删除吗？', function(
							r) {
						if (r) {
							$.post('del_biz_act', {
								id : row.id,
								title:row.title,
								parentId:row.parentId
							}, function() {
							$('#business_datagrid').datagrid('reload');
								
							});
						}
					});
		}
	}
/*	删除导航问题*/
	function del_qst() {
		var row = $('#question_datagrid').datagrid('getSelected');
		if (row) {
			$.messager.confirm('提示',
					'确认删除吗？', function(
							r) {
						if (r) {
							$.post('del_qst_act', {
								id : row.id,
								content:row.content,
//								parentId:row.parentId
							}, function() {
							$('#question_datagrid').datagrid('reload');
								
							});
						}
					});
		}
	}
	function del_opt(){
		var row = $('#option_datagrid').datagrid('getSelected');
		if (row) {
			$.messager.confirm('提示',
					'确认删除吗？', function(
							r) {
						if (r) {
							$.post('del_opt_act', {
								id : row.id
//								content:row.content,
//								parentId:row.parentId
							}, function() {
							$('#option_datagrid').datagrid('reload');
								
							});
						}
					});
		}
		
		
	}