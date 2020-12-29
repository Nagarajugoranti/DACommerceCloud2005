<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<spring:htmlEscape defaultHtmlEscape="true" />

<c:url value="/search/" var="searchUrl" />
<spring:url value="/search/autocomplete/{/componentuid}" var="autocompleteUrl" htmlEscape="false">
     <spring:param name="componentuid"  value="${component.uid}"/>
</spring:url>

<div class="ui-front">
	<form name="search_form_${fn:escapeXml(component.uid)}" method="get"
		action="${fn:escapeXml(searchUrl)}" id="search-form1" >
		<div class="input-group">
			<spring:theme code="search.placeholder" var="searchPlaceholderHtml" />

			<ycommerce:testId code="header_search_input">
				<c:set var="optionsJson">
					{
						"autocompleteUrl" : "${ycommerce:encodeJSON(autocompleteUrl)}",
						"minCharactersBeforeRequest" : "${ycommerce:encodeJSON(component.minCharactersBeforeRequest)}",
						"waitTimeBeforeRequest" : "${ycommerce:encodeJSON(component.waitTimeBeforeRequest)}",
						"displayProductImages" : "${ycommerce:encodeJSON(component.displayProductImages)}"
					}
				</c:set>
				<input type="text" id="js-site-search-input"
					class="form-control js-site-search-input" name="text" value=""
                    maxlength="100" placeholder="${searchPlaceholderHtml}"
					data-options="${fn:escapeXml(optionsJson)}" autofocus>
			</ycommerce:testId>

			<span class="input-group-btn">
			 <ycommerce:testId code="header_search_button">
			 		<button  type="button" id="speech" class="btn" >
						<i class="fa fa-microphone"></i>
					</button>
					<button class="btn btn-link js_search_button" type="submit" disabled>
						<span class="glyphicon glyphicon-search"></span>
					</button>

					
				</ycommerce:testId>
			</span>
		</div>
	</form>

</div>

<script type="text/javascript">
var inputform = document.getElementById('search-form1');
var searchFormInput = inputform.elements['text'];
// The speech recognition interface lives on the browsers window object
const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition; // if none exists -> undefined
if(SpeechRecognition) {
  console.log("Your Browser supports speech Recognition");
  
  const recognition = new SpeechRecognition();
  recognition.continuous = true;
  // recognition.lang = "en-US";
	
  searchFormInput.style.paddingRight = "50px";
  const micBtn = document.getElementById('speech');
  const micIcon = micBtn.firstElementChild;
  
  micBtn.addEventListener("click", micBtnClick);
  function micBtnClick() {
    if(micIcon.classList.contains("fa-microphone")) { // Start Voice Recognition
      recognition.start(); // First time you have to allow access to mic!
    }
    else {
      recognition.stop();
    }
  }
  recognition.addEventListener("start", startSpeechRecognition); // <=> recognition.onstart = function() {...}
  function startSpeechRecognition() {
    micIcon.classList.add("Blink");
    searchFormInput.focus();
    console.log("Voice activated, SPEAK");
  }
  recognition.addEventListener("end", endSpeechRecognition); // <=> recognition.onend = function() {...}
  function endSpeechRecognition() {
    micIcon.classList.remove("Blink");
    searchFormInput.focus();
    console.log("Speech recognition service disconnected");
  }
  recognition.addEventListener("result", resultOfSpeechRecognition); // <=> recognition.onresult = function(event) {...} - Fires when you stop talking
  function resultOfSpeechRecognition(event) {
    const current = event.resultIndex;
    const transcript = event.results[current][0].transcript;
    console.log(transcript);
    if(transcript.toLowerCase().trim()==="stop recording") {
      recognition.stop();
    }
    else if(!searchFormInput.value) {
      searchFormInput.value = transcript;
      
      setTimeout(() => {
         inputform.submit();
       }, 500); 
    }
    else {
      if(transcript.toLowerCase().trim()==="go") {
    	  inputform.submit();
      }
      else if(transcript.toLowerCase().trim()==="reset input") {
        searchFormInput.value = "";
      }
      else {
        searchFormInput.value = transcript;
        searchFormInput.focus();
        inputform.submit();
      }
    }
  }   
}
else {
  console.log("Your Browser does not support speech Recognition");
  var element = document.getElementById('speech');
  element.parentNode.removeChild(element);
}
</script>