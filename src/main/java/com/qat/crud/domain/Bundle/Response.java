package com.qat.crud.domain.Bundle;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qat.crud.domain.Bundle.model.Bundle;

public class Response<R, O> {
	
    private List<R> data = EMPTY_LIST;
    private STATUSERROR statusError;
    private List<ValidationError> messages = EMPTY_LIST;

    protected static final List EMPTY_LIST = Collections.emptyList();

    public O withDataList(List<R> data) {
      setData(data);
      return (O) this;
    }

    public O withData(R data) {
      setData(List.of(data));
      return (O) this;
    }


    public O withMessages(List<ValidationError> messages) {
      setMessages(messages);
      return (O) this;
    }

    public O withStatus(STATUSERROR statusError) {
      setStatus(statusError);
      return (O) this;
    }


    public O withException(Exception e) {
      setStatus(STATUSERROR.EXCEPTIONERROR);
      return (O) this;
    }

    public List<R> getData() {
      return data;
    }

    public STATUSERROR getStatusError() {
      return statusError;
    }

    public List<ValidationError> getMessages() {
      return messages;
    }

    public void setData(List<R> data) {
      this.data = data;
    }

    public void setStatus(STATUSERROR statusError) {
      this.statusError = statusError;
    }

    public void setMessages(List<ValidationError> messages) {
      this.messages = messages;
    }

    public ResponseEntity<?> toResponseEntity() {
      return new ResponseResponseEntityAdapter(this);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Response other = (Response) obj;
        return Objects.equals(data, other.data) && Objects.equals(messages, other.messages) && statusError == other.statusError;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, messages, statusError);
    }
}
