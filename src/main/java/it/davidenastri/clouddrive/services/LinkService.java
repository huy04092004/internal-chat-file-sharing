package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.mapper.LinkMapper;
import it.davidenastri.clouddrive.model.Link;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class LinkService {

    private final LinkMapper linkMapper;

    public LinkService(LinkMapper linkMapper) {
        this.linkMapper = linkMapper;
    }

    public Link createShareableLink(int userId, Integer fileId, Integer folderId, Timestamp expiresAt) {
        Link link = new Link();
        link.setLinkUrl(UUID.randomUUID().toString()); // Tạo URL duy nhất

        link.setFileId(fileId); // Có thể là null
        link.setFolderId(folderId);

        if (expiresAt != null) {
            link.setExpiresAt(expiresAt);
        }

        link.setCreatedBy(userId);

        linkMapper.insertLink(link);
        return link;
    }


    public Link getLinkById(int linkId) {
        return linkMapper.getLinkById(linkId);
    }

    public void deleteLink(int linkId) {
        linkMapper.deleteLink(linkId);
    }

    private String generateUniqueUrl() {
        return UUID.randomUUID().toString(); // Tạo URL duy nhất
    }

    public Link getLinkByUrl(String linkUrl) {
        return linkMapper.getLinkByUrl(linkUrl);

    }
}
