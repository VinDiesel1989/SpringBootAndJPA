/**
 * 
 */
$(function(){
	$.ajax({
		type:'GET',
		url:"/topics",
		success:function(data){
			console.log(data);
		},
		error:function(){
			alert("error");
		}
	});
	
	alert("this load masonry");
	 // #thumbs 为包含所有图片的容器
    var $container = $('#thumbs');
    // 使用 imagesLoaded() 修复该插件在 chrome 下的问题
    $container.imagesLoaded(function(){
      $container.masonry({
        // 每一列数据的宽度，若所有栏目块的宽度相同，可以不填这段
        columnWidth: 279,
        // .imgbox 为各个图片的容器
        itemSelector : '.imgbox'
      });
    });
    alert("loaded masonry");
})