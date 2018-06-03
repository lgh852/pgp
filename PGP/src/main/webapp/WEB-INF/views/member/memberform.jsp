<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<div class="py-5 text-center" style="margin:auto">
        <img class="d-block mx-auto mb-4" src="<%=request.getContextPath()%>/resources/images/home.png"  alt="" width="72" height="72">
        <h2>Checkout form</h2>
        <p class="lead">회원가입을 하고 많은 정보를 공유하고 소통해보세요~</p>
      </div>
	
	
	
	
	
	
	
	
	
	
	
  <form action="<%=request.getContextPath()%>/member/memberform" method="post" id="memberform">
        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 50px;">
            <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="member_id" id="userId" placeholder="아이디" style="border-style: none; width: 100% ">
            <span id="useridck"></span>
                </span>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 50px;">
            <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="member_pw" id="userPw" placeholder="비밀번호" style="border-style: none; width: 100% ">
            <span id="userPwck"></span>
                </span>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 50px;">
            <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="userPw" id="userPw2" placeholder="비밀번호확인" style="border-style: none; width: 100% ">
            <span id="userPwck2"></span>
                </span>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 50px;">
            <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="member_name" id="userName" placeholder="이름" style="border-style: none; width: 100% ">
            <span id="userNameck"></span>
                </span>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 50px;">
            <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="member_nickname" id="userNickName" placeholder="닉네임" style="border-style: none; width: 100% ">
            <span id="NickNameck"></span>
                </span>
            </div>
        </div>

        <div class="btn-group btn-group-toggle" data-toggle="buttons">
            <label class="btn btn-secondary active" style="width: 200px;">
        <input type="radio" name="member_gender" id="option1" autocomplete="off" checked value="man"> 남성
            </label>
            <label class="btn btn-secondary" style="width: 200px;">
        <input type="radio" name="member_gender" id="option2" autocomplete="off" value="woman ">여성
  </label>

        </div>
        <div class="input-group mb-3">
            <div class="form-control">
                <td>생년월일</td>

                <select class="custom-select" id="year" style="width: 140px;" name="year">
            
            <option value="0">선택하세요</option>
    
            </select>년


                <select class="custom-select" id="month" style="width: 140px;" name="month">

				   <option value="0">선택하세요</option>
					</select>월

                <select class="custom-select" id="day" style="width: 140px;" name="day">
					   <option value="0">선택하세요</option>

					</select>일

            </div>
        </div>
        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 50px;">
                     <select class="custom-select" id="phone1" style="width: 140px;" name="phone1">

				        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="018">018</option>
					</select>
                    <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="phone2" id="phone2" placeholder="0000" style="border-style: none; width: 300px ">
                    <input type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="phone3" id="phone3" placeholder="0000" style="border-style: none; width: 300px ">
                    
            <span id="phoneck"></span>
                </span>
            </div>
        </div>

        <div class="input-group mb-3">
            <div class="form-control">
                <span style="display: block; height: 30px;">자기소개</span>
            <textarea type="text" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="member_intro" id="member_intro" placeholder="자기소개" style=" width: 100% " cols="40" rows="8">
           
            </textarea>
                
            </div>
        </div>


        <input type="submit" value="회원가입">
    </form>