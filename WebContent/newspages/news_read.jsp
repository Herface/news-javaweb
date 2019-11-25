<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="../css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	  		function check(){
	  			var cauthor = document.getElementById("cauthor");
	  			var content = document.getElementById("ccontent");
	  			if(cauthor.value == ""){
	  				alert("用户名不能为空！！");
	  				return false;
	  			}else if(content.value == ""){
	  				alert("评论内容不能为空！！");
	  				return false;
	  			}
	  			return true;
	  		}
	  	</script>
</head>
<body>
<div id="header">
<!--  
  <div id="top_login">
    <label> 登录名 </label>
    <input type="text" id="uname" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="upwd" value="" class="login_input" />
    <input type="button" class="login_sub" value="登录" onclick="login()"/>
    <label id="error"> </label>
    <a href="../index.jsp" class="login_link">返回首页</a> <img src="../images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  -->
  <div id="nav">
    <div id="logo"> <img src="../images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="../images/a_b01.gif" alt="" /> </div>
    <p>
    	<a href="${pageContext.request.contextPath}/">返回首页</a>
    </p>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="../images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> 重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾 </b></a> </li>
        <li> <a href='#'><b> 发改委：4万亿投资计划不会挤占民间投资空间 </b></a> </li>
        <li> <a href='#'><b> 河南2个乡镇政绩报告内容完全一致引关注 </b></a> </li>
      </ul>
    </div>
    <h1> <img src="../images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> 日本首相鸠山首次全面阐述新政府外交政策 </b></a> </li>
        <li> <a href='#'><b> 黎巴嫩以色列再次交火互射炮弹 </b></a> </li>
        <li> <a href='#'><b> 伊朗将于30日前就核燃料供应方案作出答复 </b></a> </li>
        <li> <a href='#'><b> 与基地有关组织宣称对巴格达连环爆炸负责 </b></a> </li>
      </ul>
    </div>
    <h1> <img src="../images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> 施瓦辛格启动影视业回迁计划 推进加州经济复苏 </b></a> </li>
        <li> <a href='#'><b> 《沧海》导演回应观众质疑 自信能超越《亮剑》 </b></a> </li>
        <li> <a href='#'><b> 《海角七号》导演新片开机 吴宇森等出席 </b></a> </li>
        <li> <a href='#'><b> 《四大名捕》敦煌热拍 八主演飙戏火花四溅 </b></a> </li>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="../images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${news.ntitle}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">${news.ncreatedate}</td>
            <td align="left">${news.ntname}</td>
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2"> 
            ${news.ncontent}
      <!--        
            对于几近保级成功的深足来说，自从撞衫事件被足协扣罚三分之后，在最近的9轮比赛中，可以说奇迹般地取得了5胜4平的骄人战绩。但是质疑也随之 而来，这其中，有人说深足用钱收买了对手，也有人讲是私下进行了“人情交易”，特别是在上轮客场战胜成都谢菲联队后，“怀疑论”更是甚嚣尘上。
              昨天下午，深足主教练谢峰以及助理教练刘文斌、黄庆良集体接受了晶报记者的独家专访，详细介绍了他们接手深足以来的12轮联赛一些鲜为人知的“故事”。
              买通对手？我们没钱！
              晶报：有媒体做过统计，单从咱们新的教练组接手球队后12轮联赛的积分看，可以排在全部16支中超球队的前两名，于是有人会很自然地联想到，我们获得的这些分数，是不是来得不干净？
              谢峰：别的球队怎么样，我不清楚，但是要是说深圳队用钱收买过对手，这是对我们全队的侮辱！让对手送分必须具备两种可能吧，一是我们给人家钱， 但是我可以说，深足没钱，即使有这个心，我们也没这个能力；二是对手给我们个人情，但是你知道吗，不知道多少人都希望我们深圳队“死”呢！
              刘文斌：有一些报道，我们看了非常气愤，这是对我们全队的侮辱。我们队是一穷二白，拿什么去跟人家进行交易？
              黄庆良：就说上轮我们打成都吧。从我这个教练的角度看，成都跟我们的心态不一样。他们是已经保级，而我们则必须要拿三分，所以他们在场上踢得不 紧是好理解的。我做过运动员，知道这股“气”对比赛的影响程度。而且你知道吗，当年王宝山(现成都队主帅)在深圳的时候，与谢峰根本就“尿”不到一个壶 里，在成都见面，两个人也只是礼节性地握一下手，一句话没有。所以，王宝山怎么可能送分给谢峰呢？ </td>
          -->
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
          <td colspan="6"> 暂无评论！ </td>
          <tr>
            <td colspan="6"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <form action="${pageContext.request.contextPath}/comment" method="post" onsubmit="return check()">
        <input type="hidden" value="${news.nid }" name="cnid">
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td> 用户名： </td>
              <td><input id="cauthor" name="cauthor" placeholder="这家伙很懒什么也没留下"/>
                IP：
                <input name="cip" value="<%=request.getRemoteHost() %>"
											readonly="readonly"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
        </form>
        <c:forEach items="${news.comments}" var="comment">
        	<li><a href="javascript:;">${comment.cauthor}:</a>&nbsp;&nbsp;${comment.ccontent}&nbsp;&nbsp;&nbsp;&nbsp;${comment.cip} &nbsp;&nbsp;&nbsp;&nbsp;${comment.cdate}</li>
        </c:forEach>
        
      </ul>
    </div>
  </div>
</div>
<%@include file="../index-elements/index_bottom.html"%>
<%-- 
<%session.removeAttribute("news");%>
--%>
</body>
</html>
