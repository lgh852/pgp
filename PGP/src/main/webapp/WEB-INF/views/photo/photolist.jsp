<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



    

        <style>
            .size {
                border: 1px solid black;
                width: 100%;
                height: 200px;
            }

            .censize {
                margin-top: 30px;
                border: 1px solid black;
                width: 100%;
                height: 2000px;
            }


            .viewli {
                float: left;
                margin-top: 50px;
                margin-left: 60px;
                list-style-type: none;
            }

            .info {
                border: 1px solid black;
                width: 280px;
                height: 70px;


            }

            .memebrinfo {
                border: 1px solid black;
                width: 30px;
                height: 30px;
                border-radius: 100px 100px 100px 100px;
                padding: 1px;



            }

            .overfl {
                overflow: hidden;
                position: relative;
            }

            .memid {
                position: absolute;
                top: 7px;
                margin: 0 3;
                left: 45px;
            }

            .a1 {
                display: block;
                width: 180;


            }

            .di2 {
                position: absolute;
                top: 230px;
                left: 10px;
                overflow: hidden;
            }

            .fontcount {
                font-size: 16px;
                font-weight: 100;

            }

            .m10right {
                margin-right: 6px
            }
			.ss{
				display: none;
			}
        </style>

        <div class="size"> </div>
        <div class="censize">

            <c:forEach var="list" items="${list}" varStatus="status">
          
                <ul>
                    <li class="viewli" style="position: relative">
                        <a href="#">
                            <div style="height: 280"><img src="<%=request.getContextPath()%>/resources/BoardPhoto/${list.photo_name}" width="280" height="280">

                                <div class="di2 fontcount"><img src="html.css/25.jpg" width="37" height="37" class="m10right">${list.board_scrap} <img src="html.css/25.jpg" width="37" height="37" class="m10right">${list.board_comment} <img src="html.css/25.jpg" width="37" height="37" class="m10right"><span id ="likecnt${status.count}">${list.board_like}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;조회수&nbsp;&nbsp;<span id="f">${list.board_cnt}</span></div>

                            </div>
                        </a>
                        <div class="info">


                            <div class="overfl">

                                <a href="#" class="a1">
                                <div class="memebrinfo" style="background-image:url('<%=request.getContextPath()%>/resources/memberphoto/${list.member_photo}');">
                                    <div>
                                        <p class="memid">${list.member_id}</p>
                                        
                                    </div>
                                </div>
                                    </a>
                                  
                                <a style="position: absolute;right:5px;top:3px;" href="#" class="like"><img src="#" width="30px" height="30px"></a>
                               	<a style="position: absolute;right:5px;top:3px;" href="#" class="like"><img src="#" width="30px" height="30px"></a>
                                 <c:if test="${list.likeck==null}">
                                <a style="position: absolute;right: 35px; top:3px" onclick="liclick(${status.count})">
                                   <img class ="heart${status.count}" src="<%=request.getContextPath()%>/resources/images/heart1.png" width="30px" height="30px"></a></c:if>
                                    <c:if test="${list.likeck!=null}">
                                <a style="position: absolute;right: 35px; top:3px" onclick="liclick(${status.count})">
                                   <img class ="heart${status.count}" src="<%=request.getContextPath()%>/resources/images/heart2.jpg" width="30px" height="30px"></a></c:if>
                                <p>${list.board_contents}</p>
                                
                            </div>
                        </div>
                    </li>
                </ul>
                <ul >
                <li class="ss"><input type="hidden" class="likech${status.count}" value="${list.like_check}"></li>
				
                <li class="ss"><input type="hidden" class="bidx${status.count}" value="${list.board_idx}"></li>
                </ul>
                	
            </c:forEach>
        </div>
    