package org.utb.vcp.model.payload.request;

public class CodDominioRequest {
    private String codDominioRequest;

    public String getCodDominioRequest() {
        return codDominioRequest;
    }

    public void setCodDominioRequest(String codDominioRequest) {
        this.codDominioRequest = codDominioRequest;
    }

    @Override
    public String toString() {
        return "CodDominioRequest [codDominioRequest=" + codDominioRequest + "]";
    }

}
